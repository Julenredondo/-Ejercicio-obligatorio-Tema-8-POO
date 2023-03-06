package pruebacuentas;

public class Persona {
    private final String DNI;//DNI de cada objeto persona
    private Cuenta cuentasbanc[] = new Cuenta [3];//vamos a ir almacenando la cuentas de cada una de las personas
    private int contadorcuenta = 0;//utilizaremos este contador para saber cuantas cuentas tiene
    
    public Persona (String dni){
        this.DNI = dni;
    }
    
    public void añadirCuenta(String numerocuenta, double sald){
        if(numerocuenta.matches("[A-Z]{2}\\d{18}")){//si la cuenta cumple los requisitos entrara
            if (contadorcuenta<=2){//cuando el contador entre en el rango de cuentas validas que son 3 dejara añadir
               cuentasbanc[contadorcuenta] = new Cuenta(numerocuenta,sald);//instanciamos cuenta de tipo Cuenta
               contadorcuenta++;//cuando se cree un objeto cuenta nuevo su contador se incremetara
            }else{
                System.err.println("Lo sentimos, ya tienes el maximo de 3 cuentas.");//si ya ha llegado el limite saltara este error
            }
        }else{
            System.err.println("La cuenta es INCORRECTA.");//cuando la cuenta no cumpla los requisitos dara error.
        }
    }
    
    public boolean PersonaMorosa(){
        boolean morosa = false;
        
        //comprobamos si alguna cuenta tiene saldo negativo
        for (int i=0;i<this.contadorcuenta;i++){
            if(cuentasbanc[i].getSaldo()<0){
                morosa = true;
            }
        }
        return morosa;
    }
    //metodo que imprime los datos de un objeto Persona
    public void imprimeDatos(){
        System.out.println("-Los datos de la persona con DNI "+ this.DNI + " son:");
        System.out.println("----------------------------------------------------");
        for (int i=0;i<contadorcuenta;i++){
            cuentasbanc[i].imprimeCuenta(i);//llama al metodo que imprime los datos de la cuenta
        }
    }
    
    public String getDNI(){
        return this.DNI;
    }
    
    public void ingresaDinero(String cuenta, double cantidad){
        boolean ingresado=false;
        for (int i=0;i<contadorcuenta;i++){
            if (cuentasbanc[i].getnumero().equals(cuenta)){//cuando se encuentre la cuenta entrara
                cuentasbanc[i].recibirAbonos(cantidad);//llamara al metodo que suma la cantidad a la cuenta
                ingresado=true;//si se ejecuta el proceso cambiara la variable booleana
            }
        }
        if(ingresado){//motrara el mensaje segun si ha sido exitoso o no
            System.out.println("SE HA INGRESADO CON EXITO.");
        }else{
            System.err.println("La cuenta no ha sido encontrada.");
        }
    }
    
    public void restarDinero (String cuenta, double cantidad){
        boolean restado=false;
        for (int i=0;i<contadorcuenta;i++){
            if (cuentasbanc[i].getnumero().equals(cuenta)){//cuando se encuentre la cuenta entrara
                cuentasbanc[i].pagarRecibos(cantidad);//llamara al metodo que resta la cantidad a la cuenta
                restado=true;//si se ejecuta el proceso cambiara la variable booleana
            }
        }
        if (restado){//motrara el mensaje segun si ha sido exitoso o no
            System.out.println("EL PAGO SE HA COMPLETADO CON EXITO.");
        }else{
            System.err.println("La cuenta no ha sido encontrada.");
        }
    }
    //comprobara si una cuenta existe
    public boolean comprobarCuenta(String cuenta){
        boolean encontrada=false;
        for (int i=0;i<contadorcuenta;i++){
            if(cuentasbanc[i].getnumero().equals(cuenta)){
                encontrada=true;
            }
        }
        if(!encontrada){
            System.err.println("La cuenta no ha sido encontrada.");
        }
        return encontrada;
    }
}

package pruebacuentas;

public class Cuenta {
    private String numero;//numero de cuenta
    private double saldo;//saldo de la cuenta
    
    public Cuenta (String num, double saldo){
            this.numero = num;
            this.saldo = saldo;
    }
    //imprime los datos de la cuenta
    public void imprimeCuenta(int cont){
        System.out.println("-El numero de cuenta "+(cont+1)+" es: "+this.numero);
        System.out.println("-El saldo de la cuenta "+(cont+1)+" es: "+this.saldo);
        System.out.println("------------------------------------------------------");
    }
    
    //devolvera el numero de cuenta
    public String getnumero(){
        return this.numero;
    }
    //devolvera el saldo de la cuenta
    public double getSaldo(){
        return this.saldo;
    }
    //acumulara los abonos
    public void recibirAbonos(double cantidad){
        this.saldo += cantidad;
    }
    //restara los recibos
    public void pagarRecibos(double cantidad){
        this.saldo -= cantidad;
    }
}

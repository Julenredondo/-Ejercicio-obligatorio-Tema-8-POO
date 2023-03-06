package pruebacuentas;

//autor Julen Redondo Perez

import java.util.Scanner;
public class PruebaCuentas {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int opcion, contpers=0;//contpers sera el contador que utilizaremos para ir almacenando las personas y opcion para el menu
        String persona, cuentabanc, cuentabanc2;//persona sera el DNI que tendremos que guardar
        double saldocuenta;
        Persona personas[]= new Persona [10];//almacenara las personas de tipo Persona
        boolean DNIcorrecto=false;//lo utilizaremos para comprobar si los procesos se cumplen correctamente
        
        do{
        //Vamos a imprimer el menu
        System.out.println("----------MENU DE OPCIONES----------");
        System.out.println("1. Instanciar objetos de tipo Persona.\n"
                        + "2. Instanciar objetos de tipo Cuenta y asociarlo a una persona.\n"
                        + "3. Mostrar datos de una persona (por su DNI).\n"
                        + "4. Recibir la nómina mensual de una persona (por DNI y numero de cuenta).\n"
                        + "5. Recibir un pago (por DNI y numero de cuenta).\n"
                        + "6. Realizar transferencia entre cuentas.\n"
                        + "7. Imprimir las personas morosas.\n"
                        + "------Si deseas finalizar el menu escribe 0------");
        System.out.print("Escribe el numero de la opcion que quieras: ");
        opcion = sc.nextInt();//el usuario nos dara la opcion que desea
        sc.nextLine();
        System.out.println("---------------------------------------------------------------------");
        
        //entrara en la opcion indicada por el usuario
        switch(opcion){
            case 1:
                System.out.print("Escribe el DNI de la persona: ");//pedimos DNI
                persona = sc.nextLine();
                if(persona.matches("\\d{8}[A-Z]")){//comprobamos que el DNI es correcto
                    personas[contpers]= new Persona(persona);//almacenamos en la posicion correspondiente el DNI de la nueva persona
                    contpers++;//acumulamos una persona almacenada
                }else{
                    System.err.println("El DNI no es correcto.");//en el caso de que el DNI sea incorrecto saltara un error
                }
                
                break;
            
            case 2:
                System.out.print("Escribe el DNI de la persona a la que quieres asociar la cuenta: ");
                persona = sc.nextLine();
                DNIcorrecto=false;//aseguramos valor al DNI correcto
                
                for (int i=0;i<contpers;i++){//buscamos a que persona asociaremos la cuenta que creara el usuario
                    if (personas[i].getDNI().equals(persona)){//cuando encuentre el DNI que ha indicado el usuario entrara en el proceso
                        System.out.print("Escribe el numero de cuenta (recuerda son 2 letras seguido de 18 digitos):");
                        cuentabanc = sc.nextLine();
                        System.out.print("Escribe el saldo de la cuenta: ");
                        saldocuenta = sc.nextDouble();
                        personas[i].añadirCuenta(cuentabanc, saldocuenta);//llamamos al metodo que añadira la cuenta a la persona indicada
                        DNIcorrecto=true;//indicaremos que el DNI ha sido encontrado
                    }
                }
                if(!DNIcorrecto){
                        System.err.println("El DNI no existe.");//si no se encuentra el DNI correcto sera lo contrario de true (false) y el DNI no existira
                    }
                break;
            
            case 3:
                System.out.print("Escribe el DNI de la persona de la que quieres mostrar los datos: ");
                persona = sc.nextLine();
                DNIcorrecto=false;//aseguramos valor al DNI correcto
                
                for (int i=0;i<contpers;i++){//buscamos la persona de la que mostrara los datos
                    if (personas[i].getDNI().equals(persona)){//cuando encuentre el DNI entrara en el proceso
                        personas[i].imprimeDatos();//llamamos a el metodo que nos imprime los datos de la persona
                        DNIcorrecto=true;//indicamos que se ha encontrado el DNI
                    }
                }
                if(!DNIcorrecto){
                    System.err.println("El DNI no existe.");//si no se encuentra el DNI correcto sera lo contrario de true (false) y el DNI no existira
                }
                break;
            
            case 4:
                System.out.print("Escribe el DNI de la persona que recibe la nomina:");
                persona = sc.nextLine();
                DNIcorrecto=false;//aseguramos valor al DNI correcto
                
                for(int i=0;i<contpers;i++){//buscamos la persona que recibe la nomina
                    if(personas[i].getDNI().equals(persona)){//cuando encuentre el DNI entrara en el proceso
                        System.out.print("-Escribe el numero de cuenta bancaria donde quieres ingresar la nomina:");
                        cuentabanc=sc.nextLine();
                        System.out.print("-Escribe cual sera la cantidad de la nomina a ingresar: ");
                        saldocuenta=sc.nextDouble();
                        personas[i].ingresaDinero(cuentabanc, saldocuenta);//llamaremos al metodo que ingresara la nomina
                        DNIcorrecto=true;//indicamos que se ha encontrado el DNI
                    }
                }
                if(!DNIcorrecto){
                    System.err.println("El DNI no existe.");//si no se encuentra el DNI correcto sera lo contrario de true (false) y el DNI no existira
                }
                break;
                
            case 5:
                System.out.print("Escribe el DNI de la persona que recibe el pago:");
                persona = sc.nextLine();
                DNIcorrecto=false;//aseguramos valor al DNI correcto
                
                for(int i=0;i<contpers;i++){//buscamos la persona que recibe el pago
                    if(personas[i].getDNI().equals(persona)){//cuando encuentre el DNI entrara en el proceso
                        System.out.print("-Escribe el numero de cuenta bancaria donde se va a recibir el pago:");
                        cuentabanc=sc.nextLine();
                        System.out.print("-Escribe cual sera la cantidad del pago a restar: ");
                        saldocuenta=sc.nextDouble();
                        personas[i].restarDinero(cuentabanc, saldocuenta);//llamaremos al metodo que restara el dinero del pago
                        DNIcorrecto=true;//indicamos que se ha encontrado el DNI
                    }
                }
                if(!DNIcorrecto){
                    System.err.println("El DNI no existe.");//si no se encuentra el DNI correcto sera lo contrario de true (false) y el DNI no existira
                }
                break;
                
            case 6:
                System.out.print("Escribe el DNI de la persona que hace la transfererecia:");
                persona = sc.nextLine();
                DNIcorrecto=false;//aseguramos valor al DNI correcto
                
                for (int i=0;i<contpers;i++){//buscamos la persona que realiza la transferencia
                    if(personas[i].getDNI().equals(persona)){//cuando encuentre el DNI entrara en el proceso
                        System.out.print("-Escribe el numero de cuenta bancaria de la cual se realizara la transferencia:");
                        cuentabanc=sc.nextLine();//cuenta bancaria a la que se restara el dinero
                        System.out.print("-Escribe cual sera la cantidad de la transferencia: ");
                        saldocuenta=sc.nextDouble();
                        sc.nextLine();//limpiamos buffer
                        if(personas[i].comprobarCuenta(cuentabanc)){//si encuentra la cuenta seguira el proceso
                            System.out.print("-Escribe el DNI asociado a la cuenta a la que quieres hacer la transferencia:");
                            persona = sc.nextLine();//DNI de la persona que recibira la transferencia
                            for(int j=0;j<contpers;j++){//buscamos el DNI de la persona que recibira la transferencia
                                if(personas[j].getDNI().equals(persona)){//cuando encuentre el DNI de quien recibira la transferencia seguira el proceso
                                    System.out.print("-Escribe cual es la cuenta a la que quieres hacer la transferencua:");
                                    cuentabanc2=sc.nextLine();//es la cuenta que recibira la transferencia
                                    if(personas[j].comprobarCuenta(cuentabanc2)){//si la cuenta existe seguira el proceso
                                        personas[i].restarDinero(cuentabanc, saldocuenta);//restaremos el dinero de la cuenta que realiza la transferencia
                                        personas[j].ingresaDinero(cuentabanc2, saldocuenta);//ingresaremos el dinero a la cuenta que recibe la transferencia
                                        persona="";//cambiamos el valor de la variable para que no vuelva a entrar en el bucle(si no volveria a entrar con el valor de la persona que recibe la transferencia)
                                        DNIcorrecto=true;//cuando el proceso este realizado la variable cambiara
                                    }
                                }
                            }
                        }
                    }
                }
                if(!DNIcorrecto){//si el booleano es lo contrario de true(false) querra decir que el proceso no se ha realizado, con lo cual algun valor sera erroneo
                    System.err.println("El valor ha sido incorrecto.");//saltara el error correspondiente
                }
                break;
            
            case 7:
                System.out.println("Las personas mororsas son: \n"
                        + "---------------------------------------------------------------------");
                for (int i=0;i<contpers;i++){//bucle que entrara en todas las personas que tengamos
                    if(personas[i].PersonaMorosa()){//cuando el metodo devuelva verdadero se motrara la persona
                        System.out.println("- Persona con DNI "+personas[i].getDNI());
                    }
                }
                break;
        }
        System.out.println();
        }while(opcion!=0);//mientras que el usuario no ponga 0 en la opcion no saldra del bucle
    }
}

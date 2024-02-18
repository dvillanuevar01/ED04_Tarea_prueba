import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CCuenta cuenta1;
        double saldoActual;
        float ingreso;
        float retirada;
        try (Scanner sc = new Scanner(System.in)) {
            cuenta1 = new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0);
            saldoActual = cuenta1.estado();
            System.out.println("El saldo actual es"+ cuenta1.getSaldo() );
            System.out.println("Introduce la cantidad que quieres ingresar");
            ingreso = sc.nextFloat(); sc.nextLine();
            System.out.println("Introduce la cantidad que quieres retirar");
            retirada = sc.nextFloat(); sc.nextLine();
        }

        operativa_cuenta(cuenta1,ingreso,retirada);
    }

        public static void operativa_cuenta(CCuenta cuenta,float ingresar, float retirar) {
        try {
            cuenta.retirar(retirar);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            System.out.println("Ingreso en cuenta");
            cuenta.ingresar(ingresar);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
    }
    
}

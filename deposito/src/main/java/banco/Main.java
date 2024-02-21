package src.main.java.banco;
import java.util.Scanner;

/**
 * La clase Main contiene el método principal main y otros métodos para operar con una cuenta bancaria.
 */
public class Main {

 
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        CCuenta cuenta1;
        double saldoActual;
        float ingreso;
        float retirada;
        try (Scanner sc = new Scanner(System.in)) {
            // Inicialización de la cuenta con valores predeterminados
            cuenta1 = new CCuenta("Antonio López","1000-2365-85-1230456789",2500,0);
            saldoActual = cuenta1.estado();
            System.out.println("El saldo actual es"+ cuenta1.getSaldo() );
            // Solicitar al usuario la cantidad que quiere ingresar
            System.out.println("Introduce la cantidad que quieres ingresar");
            ingreso = sc.nextFloat(); sc.nextLine();
            // Solicitar al usuario la cantidad que quiere retirar
            System.out.println("Introduce la cantidad que quieres retirar");
            retirada = sc.nextFloat(); sc.nextLine();
        }

        // Llamar al método operativa_cuenta para realizar las operaciones en la cuenta
        operativa_cuenta(cuenta1, ingreso, retirada);
    }

    /**
     * Realiza operaciones en una cuenta bancaria, como retirar e ingresar fondos.
     * @param cuenta La cuenta bancaria en la que se realizarán las operaciones.
     * @param ingresar La cantidad que se desea ingresar en la cuenta.
     * @param retirar La cantidad que se desea retirar de la cuenta.
     */
    public static void operativa_cuenta(CCuenta cuenta, float ingresar, float retirar) {
        try {
            // Intentar retirar la cantidad especificada
            cuenta.retirar(retirar);
            System.out.println("Retirada en cuenta " + retirar);
        } catch (Exception e) {
            // Capturar cualquier excepción que ocurra durante la retirada de fondos
            System.out.print("Fallo al retirar");
        }
        try {
            // Intentar ingresar la cantidad especificada
            System.out.println("Ingreso en cuenta " + ingresar);
            cuenta.ingresar(ingresar);
        } catch (Exception e) {
            // Capturar cualquier excepción que ocurra durante el ingreso de fondos
            System.out.print("Fallo al ingresar");
        }
        // Imprime el saldo actual despues de realizar las operaciones de ingresar y retirar.
        System.out.println("El saldo actual es " + cuenta.getSaldo());
        
    }
}


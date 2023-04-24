/*Realizar una clase llamada CuentaBancaria en el paquete Entidades con los 
siguientes atributos: numeroCuenta(entero), dniCliente(entero largo), 
saldoActual. Agregar constructor vacío, con parámetros, getters y setters.
Agregar la clase CuentaBancariaServicio en el paquete Servicios que contenga:
1)Método para crear cuenta pidiéndole los datos al usuario.
2)Método ingresar(double): recibe una cantidad de dinero a ingresar y se le sumará
al saldo actual.
3)4)Método retirar(double): recibe una cantidad de dinero a retirar y se le restara 
al saldo actual. Si la cuenta no tiene la cantidad de dinero a retirar se retirará 
el máximo posible hasta dejar la cuenta en 0.
5)Método extraccionRapida: le permitirá sacar solo un 20% de su saldo. Validar que 
el usuario no saque más del 20%.
6)Método consultarSaldo: permitirá consultar el saldo disponible en la cuenta.
7)Método consultarDatos: permitirá mostrar todos los datos de la cuenta.
 */
package Main.Entidad.Servicio;

import Main.Entidad.CuentaBancaria;
import java.util.Scanner;


public class CuentaBancariaServicio {
    Scanner leer = new Scanner(System.in);
    
    public CuentaBancaria crearCuenta(){
        System.out.println("Ingrese el numero de cuenta");
        int numeroCuenta =leer.nextInt();
        System.out.println("Ingrese su dni");
        long dniCliente = leer.nextLong();
        System.out.println("Ingrese el saldo de su cuenta");
        double saldoActual = leer.nextDouble();
        
        return new CuentaBancaria(numeroCuenta, dniCliente, saldoActual);
       
    }


    public void ingresar(CuentaBancaria cuenta, double cantidad) {
             
        double saldoActual = cuenta.getSaldoActual();
        System.out.println("Cuando dinero desea ingresar?");
        cantidad = leer.nextInt();
        saldoActual += cantidad;
        cuenta.setSaldoActual(saldoActual);
        System.out.println("Su saldo ahora es de: " + cuenta.getSaldoActual());
    }

    public void retirar(CuentaBancaria cuenta, double cantidad) {
        double saldoActual = cuenta.getSaldoActual();
        //do {
            System.out.println("Cuando dinero desea retirar?");
            cantidad = leer.nextInt();

            if (cantidad <= saldoActual) {
                saldoActual -= cantidad;
                cuenta.setSaldoActual(saldoActual);
                System.out.println("Su nuevo saldo es de: " + cuenta.getSaldoActual());
            } else {
                System.out.println("No se puede retirar esa cantidad. El saldo actual es de " + saldoActual);
                System.out.println("Retirando el monto máximo posible: " + saldoActual);
                cuenta.setSaldoActual(0);
            }
        //} while (cuenta.getSaldoActual() > 0);
    }
        
    

public void extraccionRapida(CuentaBancaria cuenta) {
        double saldoActual = cuenta.getSaldoActual();
        System.out.println("Desea realizar una extraccion rapida? s/n");
        String respuest = leer.next();
        if (respuest.equalsIgnoreCase("s")) {

            if (saldoActual == 0) {
                System.out.println("No se puede realizar extracción rápida. El saldo actual es cero.");

            }
            double limite = saldoActual * 0.2;
            saldoActual -= limite;
            cuenta.setSaldoActual(saldoActual);
            System.out.println("Su saldo es de: " + cuenta.getSaldoActual());
        }else{
            System.out.println("Ok, chau!!");
        }
    }

    public double consultarSaldo(CuentaBancaria cuenta) {
        return cuenta.getSaldoActual();
    }

    
    public void consultarDatos(CuentaBancaria cuenta) {
        System.out.println("Numero de cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("DNI del cliente: " + cuenta.getDniCLiente());
        System.out.println("Saldo actual: " + cuenta.getSaldoActual());
}
    
}

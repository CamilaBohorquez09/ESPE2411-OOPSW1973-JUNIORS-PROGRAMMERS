package espe.edu.ec.model;

import espe.edu.ec.utils.Validations;
import java.util.Scanner;

public class MethodOfPayment {

    public void processPayment(float total, Scanner scanner) {
        System.out.println("El total a pagar es: " + total);
        System.out.println("Seleccione el método de pago:");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta de crédito");
        int option = Validations.validarOpcion(1, 2, scanner);

        if (option == 1) {
            System.out.println("Usted ha elegido pagar en efectivo.");
            System.out.println("Pago realizado con éxito.");
        } else if (option == 2) {
            System.out.println("Usted ha elegido pagar con tarjeta de crédito.");
            System.out.println("Pago realizado con éxito.");
        }
    }
}

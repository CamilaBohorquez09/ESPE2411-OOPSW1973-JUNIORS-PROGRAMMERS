package espe.edu.ec.view;

import espe.edu.ec.model.Order;
import espe.edu.ec.model.MenuItem;
import java.util.Scanner;

public class SAMCApp {
    public static void main(String[] args) {
        MenuItem.initializeMenu();
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        
        while (true) {
            System.out.println("******** AGACHADITOS DE LA JAVI ********");
            System.out.println("1. Realizar un pedido");
            System.out.println("2. Modo Administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    order.makeOrder(scanner);
                    break;
                case 2:
                    // Lógica para modo administrador
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

package espe.edu.ec.model;

import espe.edu.ec.model.BeverageInventory.Beverage;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Robinson Bonilla
 */
public class MainInventario {
    public static void main(String[] args) {
        BeverageInventory inventory = new BeverageInventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar bebida");
            System.out.println("2. Vender bebida");
            System.out.println("3. Eliminar bebida");
            System.out.println("4. Listar bebidas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            int option = -1;

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                continue;
            }

            scanner.nextLine(); // Consumir el salto de línea

            switch (option) {
                case 1:
                    System.out.print("Ingrese el nombre de la bebida: ");
                    String name = scanner.nextLine();
                    double price = 0;
                    int quantity = 0;

                    // Manejo de errores para la entrada del precio
                    while (true) {
                        System.out.print("Ingrese el precio de la bebida: ");
                        try {
                            price = scanner.nextDouble();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese un precio valido (formato decimal).");
                            scanner.nextLine(); // Limpiar el buffer del scanner
                        }
                    }

                    // Manejo de errores para la entrada de la cantidad
                    while (true) {
                        System.out.print("Ingrese la cantidad de la bebida: ");
                        try {
                            quantity = scanner.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese una cantidad valida (numero entero).");
                            scanner.nextLine(); // Limpiar el buffer del scanner
                        }
                    }

                    scanner.nextLine(); // Consumir el salto de línea
                    inventory.addBeverage(new Beverage(name, price, quantity));
                    pauseForEffect();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la bebida que desea vender: ");
                    String sellName = scanner.nextLine();
                    inventory.sellBeverage(sellName);
                    pauseForEffect();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la bebida que desea eliminar: ");
                    String removeName = scanner.nextLine();
                    inventory.removeBeverage(removeName);
                    pauseForEffect();
                    break;
                case 4:
                    inventory.listBeverages();
                    pauseForEffect();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción invalida. Intente nuevamente.");
            }
        }
    }

    private static void pauseForEffect() {
        System.out.println("Pausando para visualizar la salida...");
        try {
            Thread.sleep(2000); // Pausa por 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("La pausa fue interrumpida.");
        }
    }
}

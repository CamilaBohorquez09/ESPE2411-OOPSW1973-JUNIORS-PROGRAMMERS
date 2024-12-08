package espe.edu.ec.utils;

import espe.edu.ec.model.MenuItem;
import java.util.Scanner;

public class AdminPermissions {

    public static void manageAdminPermissions(Scanner scanner) {
        final String ADMIN_PASSWORD = "admin123";

        System.out.print("Ingrese la contraseña de administrador: ");
        String password = scanner.nextLine();

        if (!password.equals(ADMIN_PASSWORD)) {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
            return;
        }

        System.out.println("Bienvenido al modo administrador.");
        updateInventory(scanner);
    }

    private static void updateInventory(Scanner scanner) {
        while (true) {
            MenuItem.displayMenu();
            System.out.print("Ingrese el ID del plato (0 para salir): ");
            int itemId = scanner.nextInt();
            scanner.nextLine();

            if (itemId == 0) {
                break;
            }

            MenuItem item = MenuItem.getMenuItemById(itemId);
            if (item == null) {
                System.out.println("Plato no encontrado. Intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese la cantidad a agregar al inventario: ");
            int refillAmount = scanner.nextInt();
            scanner.nextLine();

            if (refillAmount <= 0) {
                System.out.println("La cantidad debe ser mayor a 0. Intente nuevamente.");
                continue;
            }

            item.reduceInventory(-refillAmount);
            System.out.println("El inventario de '" + item.getName() + "' ha sido actualizado.");
        }
    }
}

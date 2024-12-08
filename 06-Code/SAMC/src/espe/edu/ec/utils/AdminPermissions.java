

package espe.edu.ec.utils;

import espe.edu.ec.model.MenuItem;
import java.util.Scanner;

public class AdminPermissions {
    private static void adminPermissions(Scanner scanner, ManageFileJson manageFileJson) {
    final String ADMIN_PASSWORD = "admin123";

    System.out.print("Ingrese la contraseña de administrador: ");
    String password = scanner.nextLine();

    if (!password.equals(ADMIN_PASSWORD)) {
        System.out.println("Contraseña incorrecta. Acceso denegado.");
        return;
    }

    System.out.println("Bienvenido al modo administrador.");
    System.out.println("Seleccione un plato para hacer refill de inventario:");

    while (true) {
        MenuItem.displayMenu();
        System.out.print("Ingrese el ID del plato (o '0' para salir): ");
        int itemId = scanner.nextInt();
        if (itemId == 0) break;

        MenuItem item = MenuItem.getMenuItemById(itemId);
        if (item == null) {
            System.out.println("Plato no encontrado. Intente nuevamente.");
            continue;
        }

        System.out.print("Ingrese la cantidad a agregar al inventario: ");
        int refillAmount = scanner.nextInt();
        if (refillAmount <= 0) {
            System.out.println("La cantidad debe ser mayor a 0. Intente nuevamente.");
            continue;
        }

        item.reduceInventory(-refillAmount);
        System.out.println("El inventario de '" + item.getName() + "' ha sido actualizado a " + item.getInventory() + ".");
    }
    manageFileJson.saveQuantitiesToJson();
    System.out.println("Inventario actualizado y guardado exitosamente.");
    }
}

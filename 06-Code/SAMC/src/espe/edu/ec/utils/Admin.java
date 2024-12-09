package espe.edu.ec.utils;

import espe.edu.ec.model.MenuItem;
import java.util.Scanner;

public class Admin {

    // Cambié a public para que pueda ser llamado desde otras clases
    public static void adminPermissions(Scanner scanner, ManageFileJson manageFileJson) {
        final String ADMIN_PASSWORD = "admin123"; // Contraseña para acceso

        // Solicitar contraseña de administrador
        System.out.print("Ingrese la contraseña de administrador: ");
        String password = scanner.nextLine();

        // Validar la contraseña
        if (!password.equals(ADMIN_PASSWORD)) {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
            return;
        }

        // Modo administrador activado
        System.out.println("Bienvenido al modo administrador.");
        System.out.println("Seleccione un plato para hacer refill de inventario:");

        // Ciclo para mostrar el menú y permitir agregar inventario
        while (true) {
            MenuItem.displayMenu(); // Mostrar el menú con los platos
            System.out.print("Ingrese el ID del plato (o '0' para salir): ");
            int itemId = scanner.nextInt();

            // Opción para salir
            if (itemId == 0) break;

            // Obtener el plato seleccionado
            MenuItem item = MenuItem.getMenuItemById(itemId);
            if (item == null) {
                System.out.println("Plato no encontrado. Intente nuevamente.");
                continue;
            }

            // Solicitar la cantidad a agregar al inventario
            System.out.print("Ingrese la cantidad a agregar al inventario: ");
            int refillAmount = scanner.nextInt();

            // Validar que la cantidad sea mayor que 0
            if (refillAmount <= 0) {
                System.out.println("La cantidad debe ser mayor a 0. Intente nuevamente.");
                continue;
            }

            // Actualizar el inventario del plato
            item.reduceInventory(-refillAmount);
            System.out.println("El inventario de '" + item.getName() + "' ha sido actualizado a " + item.getInventory() + ".");
        }

        // Guardar los cambios en el archivo JSON
        manageFileJson.saveQuantitiesToJson();
        System.out.println("Inventario actualizado y guardado exitosamente.");
    }
}

package espe.edu.ec.model;

import espe.edu.ec.model.Bill;
import espe.edu.ec.model.MenuItem;
import espe.edu.ec.model.SaleNote;
import espe.edu.ec.utils.AdminPermissions;
import espe.edu.ec.utils.ManageFileCsv;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Validations;

import java.util.Scanner;

public class AdminControl {

    public void refillMenuInventory(Scanner scanner, ManageFileJson manageFileJson) {
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

    public void adminPermissions(Scanner scanner, ManageFileJson manageFileJson) {
        AdminPermissions adminPermissions = new AdminPermissions();

        System.out.print("Ingrese la contrasenia de administrador: ");
        String inputPassword = scanner.nextLine();

        if (!adminPermissions.validatePassword(inputPassword)) {
            System.out.println("Contrasenia incorrecta. Acceso denegado.");
            return;
        }

        System.out.println("Bienvenido al modo administrador.");
        boolean adminRunning = true;

        ManageFileCsv manageFileCsv = new ManageFileCsv();

        while (adminRunning) {
            displayAdminMenu();
            int adminChoice = Validations.validateOption(1, 6, scanner); // Cambiado a 6 opciones.

            switch (adminChoice) {
                case 1:
                    new Bill(null, null, 0).printBill(scanner, manageFileJson);
                    break;
                case 2:
                    new SaleNote(null, null, 0).printSaleNote(scanner, manageFileJson);
                    break;
                case 3:
                    refillMenuInventory(scanner, manageFileJson);
                    break;
                case 4:
                    System.out.println("Llamando a ScreenOfChef...");
                    ScreenOfChef screenOfChef = new ScreenOfChef(new Order());
                    screenOfChef.displayOrderedDishes();
                    break;
                case 5:
                    adminRunning = false;
                    System.out.println("Saliendo del menu administrador...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    private void displayAdminMenu() {
        System.out.println("******** MENU ADMINISTRADOR ********");
        System.out.println("1. Imprimir Factura");
        System.out.println("2. Imprimir Nota de Venta");
        System.out.println("3. Hacer refill de inventario");
        System.out.println("4. Pantalla del cocinero2");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
    }
}



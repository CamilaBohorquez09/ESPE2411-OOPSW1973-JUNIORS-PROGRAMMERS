package espe.edu.ec.utils;
import espe.edu.ec.model.Bill;
import espe.edu.ec.model.MenuItem;
import espe.edu.ec.model.SaleNote;
import java.util.Scanner;

public class AdminPermissions {
    private String encryptedPassword;

    public AdminPermissions() {
        this.encryptedPassword = "cfokp123";
    }

    private String encryptPassword(String password) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char newChar = (char) ((c - base + 2) % 26 + base);
                encrypted.append(newChar);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private boolean validatePassword(String inputPassword) {
        String encryptedInput = encryptPassword(inputPassword);
        return encryptedInput.equals(encryptedPassword);
    }
    
    private void refillMenuInventory(Scanner scanner, ManageFileJson manageFileJson) {
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
        System.out.print("Ingrese la contrasenia de administrador: ");
        String inputPassword = scanner.nextLine();

        if (!validatePassword(inputPassword)) {
            System.out.println("Contrasenia incorrecta. Acceso denegado.");
            return;
        }

        System.out.println("Bienvenido al modo administrador.");
        boolean adminRunning = true;

        while (adminRunning) {
            displayAdminMenu();
            int adminChoice = Validations.validateOption(1, 5, scanner);

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
                    adminRunning = false;
                    System.out.println("Saliendo del menu administrador...");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        }
    }

    private void displayAdminMenu() {
        System.out.println("******** MENU ADMINISTRADOR ********");
        System.out.println("1. Imprimir Factura");
        System.out.println("2. Imprimir Nota de Venta");
        System.out.println("3. Hacer refill de inventario");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }
}
package espe.edu.ec.view;

import espe.edu.ec.model.Cashier;
import espe.edu.ec.utils.Admin;
import espe.edu.ec.utils.Validations;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.model.MenuItem;

import java.util.Scanner;

public class SAMCApp {
    private static boolean running = true;
    private static Scanner scanner = new Scanner(System.in);
    private static Validations validations = new Validations();
    private static ManageFileJson manageFileJson = new ManageFileJson();

    public static void main(String[] args) {
        MenuItem.initializeMenu();

        while (running) {
            System.out.println("******** AGACHADITOS DE LA JAVI ********");
            System.out.println("1. Realizar un pedido");
            System.out.println("2. Modo Administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            int choice = validations.validateOption(1, 3, scanner);

            switch (choice) {
                case 1:
                    Cashier.placeOrder(scanner, validations, manageFileJson);
                    break;
                case 2:
                    Admin.adminPermissions(scanner, manageFileJson);
                    break;
                case 3:
                    running = false;
                    manageFileJson.saveQuantitiesToJson();
                    System.out.println("Gracias por visitarnos. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

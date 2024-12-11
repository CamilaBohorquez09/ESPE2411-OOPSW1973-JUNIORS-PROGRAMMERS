package espe.edu.ec.view;

import espe.edu.ec.model.*;
import espe.edu.ec.utils.ManageFileCsv;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Validations;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class SAMCApp {
    public static void main(String[] args) {

        MenuItem.initializeMenu();
        ManageFileJson manageFileJson = new ManageFileJson();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        manageFileJson.loadQuantitiesFromJson();

        while (running) {
            displayMenu();
            int choice = Validations.validateOption(1, 6, scanner);

            switch (choice) {
                case 1:
                    Map<String, Integer> items = new HashMap<>();
                    Order order = new Order(items);
                    order.placeOrder(scanner, new Validations(), manageFileJson, new ManageFileCsv());
                    break;
                case 2:
                    new Customer("", "", "", "", "").leaveComment(scanner, manageFileJson);
                    break;
                case 3:
                    AdminControl adminControl = new AdminControl();
                    adminControl.adminPermissions(scanner, manageFileJson);
                    break;
                case 4:
                    running = false;
                    manageFileJson.saveQuantitiesToJson();
                    System.out.println("Gracias por visitarnos. ¡Vuelva Pronto!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("******** AGACHADITOS DE LA JAVI ********");
        System.out.println("1. Realizar un pedido");
        System.out.println("2. Dejar un comentario");
        System.out.println("3. Modo Administrador");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }
}

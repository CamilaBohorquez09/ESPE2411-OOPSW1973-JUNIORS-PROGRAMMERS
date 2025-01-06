package espe.edu.ec.model;

import espe.edu.ec.utils.ManageFileJson;
import java.util.Map;
import java.util.Scanner;

public class ScreenOfChef {
    private final ManageFileJson manageFileJson;

    public ScreenOfChef(ManageFileJson manageFileJson) {
        this.manageFileJson = manageFileJson;
    }

    public void displayOrderedDishes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cédula del cliente para consultar su pedido: ");
        String idCard = scanner.nextLine();

        Map<String, Integer> orders = manageFileJson.getOrderByCustomer(idCard);

        if (orders.isEmpty()) {
            System.out.println("No se encontraron pedidos para este cliente.");
        } else {
            System.out.println("Platos solicitados por el cliente con cédula " + idCard + ":");
            for (Map.Entry<String, Integer> entry : orders.entrySet()) {
                System.out.println("- Plato: " + entry.getKey() + ", Cantidad: " + entry.getValue());
            }
        }
    }
}


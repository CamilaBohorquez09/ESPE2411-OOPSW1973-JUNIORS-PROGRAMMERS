package espe.edu.ec.model;

import espe.edu.ec.utils.Validations;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {

    public Map<MenuItem, Integer> makeOrder(Scanner scanner) {
        Map<MenuItem, Integer> order = new HashMap<>();
        Validations validations = new Validations();

        while (true) {
            System.out.print("Ingrese el nombre del plato (0 para terminar): ");
            String itemName = scanner.nextLine();

            if (itemName.equalsIgnoreCase("0")) {
                break;
            }

            MenuItem item = MenuItem.getMenuItemByName(itemName);
            if (item == null) {
                System.out.println("Plato no encontrado. Intente de nuevo.");
                continue;
            }

            System.out.print("Ingrese la cantidad de " + item.getName() + ": ");
            int quantity = validations.validarCantidad(); // Usa la validación de cantidad
            if (quantity <= 0) {
                System.out.println("Cantidad no válida. Debe ser mayor que 0.");
                continue;
            }

            if (item.getInventory() >= quantity) {
                order.put(item, quantity);
                item.reduceInventory(quantity);
            } else {
                System.out.println("No hay suficiente inventario de " + item.getName());
            }
        }
        return order;
    }
}
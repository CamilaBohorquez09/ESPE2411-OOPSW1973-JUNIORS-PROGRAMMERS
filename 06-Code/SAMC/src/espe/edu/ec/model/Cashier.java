package espe.edu.ec.model;

import espe.edu.ec.utils.Validations;
import espe.edu.ec.utils.ManageFileJson;

import java.util.Scanner;

public class Cashier {



   
    public static void placeOrder(Scanner scanner, Validations validations, ManageFileJson manageFileJson) {
        MenuItem.displayMenu();

        System.out.print("Seleccione el ID del artículo para su pedido: ");
        int itemId = validations.validateInt(); 

        MenuItem item = MenuItem.getMenuItemById(itemId);
        if (item == null) {
            System.out.println("El artículo seleccionado no existe.");
            return;
        }

        System.out.print("¿Cuántas unidades desea?: ");
        int quantity = validations.validateInt();

        if (quantity > item.getInventory()) {
            System.out.println("No hay suficiente inventario para el artículo seleccionado.");
            return;
        }

        item.reduceInventory(quantity);

        System.out.println("Pedido realizado con exito: ");
        System.out.println("Articulo: " + item.getName());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Total: $" + (item.getPrice() * quantity));

        System.out.print("¿Desea una factura (1) o una nota de venta (2)? ");
        int option = validations.validateOption(1, 2, scanner);

        if (option == 1) {
            Customer customer = Customer.createCustomer();
            Bill.printBill(customer, item, quantity);
        } else if (option == 2) {
            SaleNote.printSaleNote(item, quantity);
        }
    }
}

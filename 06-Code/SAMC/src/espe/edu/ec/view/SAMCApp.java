package espe.edu.ec.view;

import espe.edu.ec.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SAMCApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Float> menuItems = new HashMap<>();
        menuItems.put("Salchichas", 5.0f); 
        menuItems.put("Pollo", 7.0f);     
        menuItems.put("Carne", 10.0f);    

        System.out.println("**************Menú de Platos****************");
        for (Map.Entry<String, Float> entry : menuItems.entrySet()) {
            System.out.println(entry.getKey() + " - Precio: $" + entry.getValue());
        }

        Map<String, Integer> order = new HashMap<>();
        boolean ordering = true;

        while (ordering) {
            System.out.print("Ingrese el nombre del plato que desea pedir: ");
            String dishName = scanner.nextLine();
            if (!menuItems.containsKey(dishName)) {
                System.out.println("Plato no disponible.");
                continue;
            }

            System.out.print("¿Cuántos platos desea?: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  
            order.put(dishName, quantity);

            System.out.print("¿Desea pedir otro plato? (si/no): ");
            String answer = scanner.nextLine();
            if (!answer.equalsIgnoreCase("si")) {
                ordering = false;
            }
        }
        
        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese su ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su teléfono: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = new Customer(name, id, email, "N/A", phoneNumber);
        Cashier cashier = new Cashier(customer);

        cashier.calculateTotal(order, menuItems);

        System.out.print("¿Desea factura o nota de venta? ");
        String documentType = scanner.nextLine();

        System.out.println("El total a pagar es: $" + cashier.getTotalToPay());

        if (documentType.equalsIgnoreCase("factura")) {
            Bill bill = new Bill(customer, order, cashier.getTotalToPay());
            System.out.println(bill);
        } else if (documentType.equalsIgnoreCase("nota de venta")) {
            SaleNote saleNote = new SaleNote(customer, order, cashier.getTotalToPay());
            System.out.println(saleNote);
        } else {
            System.out.println("Opción no válida.");
        }

        System.out.println("Gracias por su compra!");
    }
}
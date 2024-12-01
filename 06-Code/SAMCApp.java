package espe.edu.ec.view;

import espe.edu.ec.controller.ManageFileCsv;
import espe.edu.ec.controller.ManageFileJson;
import espe.edu.ec.model.Cashier;
import espe.edu.ec.model.Bill;
import espe.edu.ec.model.DishInventory;

import java.util.Scanner;

/**
 * Clase principal para ingresar datos del cliente ,mostrar menu y generar una factura.
 */
public class SAMCApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cashier cashier = new Cashier();
        ManageFileCsv manageFileCsv = new ManageFileCsv();
        ManageFileJson manageFileJson = new ManageFileJson();

        DishInventory[] menu = {
            new DishInventory(1, "Guata pequeña", "Plato tradicional de guata", 1.50f, true),
            new DishInventory(2, "Guata mediana", "Plato tradicional de guata", 2.00f, true),
            new DishInventory(3, "Guata extragrande", "Plato tradicional de guata", 2.50f, true),
            new DishInventory(4, "Papas con cuero", "Papas con cuero", 2.00f, true),
            new DishInventory(5, "Seco de chivo", "Plato con carne de chivo", 2.50f, true),
            new DishInventory(6, "Seco de chancho", "Plato con carne de chancho", 2.50f, true),
            new DishInventory(7, "Seco de costilla", "Plato con costilla", 2.50f, true),
            new DishInventory(8, "Seco de pollo", "Plato con carne de pollo", 2.50f, true),
            new DishInventory(9, "Mixto seco de pollo y guata", "Mezcla de pollo y guata", 3.50f, true),
            new DishInventory(10, "Mixto seco de costilla y guata", "Mezcla de costilla y guata", 3.50f, true),
            new DishInventory(11, "Mixto papas con cuero y guata", "Mezcla de papas con cuero y guata", 3.50f, true),
            new DishInventory(12, "Mixto seco de chivo y guata", "Mezcla de chivo y guata", 3.50f, true),
            new DishInventory(13, "Mixto seco de chancho y guata", "Mezcla de chancho y guata", 3.50f, true),
            new DishInventory(14, "Mixto seco de pollo y papas con cuero", "Mezcla de pollo y papas con cuero", 3.50f, true),
            new DishInventory(15, "Mixto seco de chancho y papas con cuero", "Mezcla de chancho y papas con cuero", 3.50f, true),
            new DishInventory(16, "Mixto seco de costilla y papas con cuero", "Mezcla de costilla y papas con cuero", 3.50f, true),
            new DishInventory(17, "Mixto seco de chivo y papas con cuero", "Mezcla de chivo y papas con cuero", 3.50f, true),
            new DishInventory(18, "Mixto con doble carne; pollo,chivo,chancho,costilla", "Plato con doble carne", 4.50f, true),
            new DishInventory(19, "Banderas", "Plato especial de banderas", 6.75f, true)
        };

       
        System.out.print("Ingrese el DNI: ");
        cashier.setDniCustomer(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Ingrese el nombre: ");
        cashier.setNameCustomer(scanner.nextLine());

        System.out.print("Ingrese la direccion: ");
        cashier.setAddressOfCustomer(scanner.nextLine());

        System.out.print("Ingrese el correo electronico: ");
        cashier.setEmailOfCustomer(scanner.nextLine());

        System.out.print("Ingrese el numero de telefono: ");
        cashier.setPhoneOfCustomer(scanner.nextLine());

        
        System.out.println("\n--- MENU DE PLATOS ---");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %s - $%.2f%n", i + 1, menu[i].getNameDish(), menu[i].getPrice());
        }

        Bill bill = new Bill(cashier);
        boolean addingItems = true;
        
        
        while (addingItems) {
            System.out.print("Ingrese el numero del plato que desea agregar a la factura o seleccione 0 para salir ): ");
            int dishOption = scanner.nextInt();

            if (dishOption == 0) {
                addingItems = false;  
            } else if (dishOption > 0 && dishOption <= menu.length) {
                DishInventory selectedDish = menu[dishOption - 1];
                if (selectedDish.isAvailable()) {
                    System.out.printf("Ha seleccionado: %s - $%.2f%n", selectedDish.getNameDish(), selectedDish.getPrice());
                    bill.addDish(selectedDish);  
                } else {
                    System.out.println("Lo sentimos, este plato no está disponible actualmente.");
                }
            } else {
                System.out.println("Opción invalida, por favor intente nuevamente.");
            }
        }

        
        manageFileCsv.saveToCsv(cashier);
        manageFileJson.saveToJson(cashier);

        
        System.out.println("\nFactura Generada:");
        System.out.println(bill);
    }
}

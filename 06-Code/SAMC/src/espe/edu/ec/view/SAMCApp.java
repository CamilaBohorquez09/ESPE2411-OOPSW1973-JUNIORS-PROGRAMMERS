package espe.edu.ec.view;

import espe.edu.ec.model.*;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SAMCApp {
    public static void main(String[] args) {
        MenuItem.initializeMenu();
        Scanner scanner = new Scanner(System.in);
        Utils validations = new Utils();
        boolean running = true;

        while (running) {
            System.out.println("******** AGACHADITOS DE LA JAVI ********");
            System.out.println("1. Realizar un pedido");
            System.out.println("2. Imprimir factura");
            System.out.println("3. Imprimir nota de venta");
            System.out.println("4. Dejar un comentario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int choice = validations.validarEntero();
            validations.validarOpcion(choice); 

            switch (choice) {
                case 1:
                    realizarPedido(scanner, validations);
                    break;
                case 2:
                    imprimirFactura(scanner);
                    break;
                case 3:
                    imprimirNotaVenta(scanner);
                    break;
                case 4:
                    dejarComentario(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Gracias por visitarnos. Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }

   private static void realizarPedido(Scanner scanner, Utils validations) {
        System.out.print("Ingrese su nombre: ");
        String name = validations.validarCadenaNoVacia();
        
        System.out.print("Ingrese su email: ");
        String email = validations.validarEmail();
        
        System.out.print("Ingrese su direccion: ");
        String address = validations.validarCadenaNoVacia();
        
        System.out.print("Ingrese su telefono: ");
        String phone = validations.validarTelefono();
        
        Customer customer = new Customer(name, email, address, phone);

        Map<String, Integer> order = new HashMap<>();

        System.out.println("Seleccione los platos (ingrese '0' para terminar): ");
        MenuItem.displayMenu();

        while (true) {
            System.out.print("Ingrese el ID del plato: ");
            int itemId = validations.validarEntero();
            if (itemId == 0) break;

            System.out.print("Ingrese la cantidad: ");
            int quantity = validations.validarEntero();

            MenuItem item = MenuItem.getMenuItemById(itemId);
            if (item != null) {
                order.put(item.getName(), quantity);
                item.reduceInventory(quantity);
            } else {
                System.out.println("Plato no encontrado.");
            }
        }

        float total = new Counter().calculateTotal(order);
        SaleNote saleNote = new SaleNote(customer, order, total);

        ManageFileJson manageFileJson = new ManageFileJson();
        manageFileJson.saveSaleNoteToJson(saleNote);
        
        Bill bill = new Bill(customer, order, total);
        manageFileJson.saveBillToJson(bill);

        System.out.println("Pedido realizado con exito.");
    }

    private static void imprimirFactura(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        
        int customerId = validations.esCedulaValida();
        scanner.nextLine();

        ManageFileJson manageFileJson = new ManageFileJson();
        Customer customer = manageFileJson.obtenerClientePorId(customerId);

        if (customer == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Map<String, Integer> order = manageFileJson.obtenerPedidoPorCliente(customerId);

        if (order.isEmpty()) {
            System.out.println("No se encontraron pedidos para este cliente.");
            return;
        }

        float total = new Counter().calculateTotal(order);
        Bill bill = new Bill(customer, order, total);
        manageFileJson.saveBillToJson(bill);

        System.out.println(bill);
    }

    private static void imprimirNotaVenta(Scanner scanner) {
        System.out.print("Ingrese el ID del cliente: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        ManageFileJson manageFileJson = new ManageFileJson();
        Customer customer = manageFileJson.obtenerClientePorId(customerId);

        if (customer == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Map<String, Integer> order = manageFileJson.obtenerPedidoPorCliente(customerId);
        float total = new Counter().calculateTotal(order);
        SaleNote saleNote = new SaleNote(customer, order, total);

        manageFileJson.saveSaleNoteToJson(saleNote);

        System.out.println("Detalles de la Nota de Venta:");
        System.out.println(saleNote);
    }

    private static void dejarComentario(Scanner scanner) {
        System.out.print("Ingrese su comentario: ");
        String comentario = scanner.nextLine();
        ManageFileJson manageFileJson = new ManageFileJson();
        manageFileJson.saveCommentToJson(comentario);
        System.out.println("Comentario guardado con exito.");
    }
}

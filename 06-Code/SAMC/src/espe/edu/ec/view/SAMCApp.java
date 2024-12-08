package espe.edu.ec.view;

import espe.edu.ec.model.*;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Validations;
import static espe.edu.ec.utils.Validations.validarCedula;
import static espe.edu.ec.utils.Validations.validarCorreo;
import static espe.edu.ec.utils.Validations.validarOpcion;
import static espe.edu.ec.utils.Validations.validarTelefono;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SAMCApp {
    public static void main(String[] args) {
        MenuItem.initializeMenu();
        ManageFileJson manageFileJson = new ManageFileJson();
        Scanner scanner = new Scanner(System.in);
        Validations validations = new Validations();
        boolean running = true;

        manageFileJson.loadQuantitiesFromJson();

        while (running) {
            System.out.println("******** AGACHADITOS DE LA JAVI ********");
            System.out.println("1. Realizar un pedido");
            System.out.println("2. Imprimir factura");
            System.out.println("3. Imprimir nota de venta");
            System.out.println("4. Dejar un comentario");
            System.out.println("5. Modo Administrador");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            int choice = validarOpcion(1, 6, scanner);

            switch (choice) {
                case 1:
                    realizarPedido(scanner, validations, manageFileJson);
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
                    adminPermissions(scanner, manageFileJson);
                    break;
                case 6:
                    running = false;
                    manageFileJson.saveQuantitiesToJson();
                    System.out.println("Gracias por visitarnos. Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }

    private static void realizarPedido(Scanner scanner, Validations validations, ManageFileJson manageFileJson) {
        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese su cedula (10 digitos): ");
        String idCard = scanner.nextLine();
        if (validarCedula(idCard)) {
            System.out.println("Cedula valida.");
        } else {
            System.out.println("Cedula no valida. Debe tener 10 digitos.");
        }

        System.out.print("Ingrese su correo electronico: ");
        String email = scanner.nextLine();
        if (validarCorreo(email)) {
            System.out.println("Correo valido.");
        } else {
            System.out.println("Correo no valido.");
        }

        System.out.print("Ingrese su direccion: ");
        String address = validations.validarCadenaNoVacia();

        System.out.print("Ingrese su telefono (9 digitos): ");
        String phone = scanner.nextLine();
        if (validarTelefono(phone)) {
            System.out.println("Telefono valido.");
        } else {
            System.out.println("Telefono no valido. Debe tener 9 digitos.");
        }

        Customer customer = new Customer(name, idCard, email, address, phone);
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
                if (item.getInventory() >= quantity) {
                    order.put(item.getName(), quantity);
                    item.reduceInventory(quantity);
                } else {
                    System.out.println("No hay suficiente inventario para " + item.getName());
                }
            } else {
                System.out.println("Plato no encontrado.");
            }
        }

        float total = new Counter().calculateTotal(order);
        SaleNote saleNote = new SaleNote(customer, order, total);

        manageFileJson.saveSaleNoteToJson(saleNote);

        Bill bill = new Bill(customer, order, total);
        manageFileJson.saveBillToJson(bill);

        manageFileJson.saveQuantitiesToJson();

        System.out.println("Pedido realizado con exito.");
    }

    private static void imprimirFactura(Scanner scanner) { 
        System.out.print("Ingrese su cedula: ");
        String idCard = scanner.nextLine();

        ManageFileJson manageFileJson = new ManageFileJson();
        Customer customer = manageFileJson.obtenerClientePorId(idCard);

        if (customer == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Map<String, Integer> order = manageFileJson.obtenerPedidoPorCliente(idCard);

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
        System.out.print("Ingrese su cedula: ");
        String idCard = scanner.nextLine();

        ManageFileJson manageFileJson = new ManageFileJson();
        Customer customer = manageFileJson.obtenerClientePorId(idCard);

        if (customer == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Map<String, Integer> order = manageFileJson.obtenerPedidoPorCliente(idCard);
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

    private static void adminPermissions(Scanner scanner, ManageFileJson manageFileJson) {
        final String ADMIN_PASSWORD = "admin123";

        System.out.print("Ingrese la contraseña de administrador: ");
        String password = scanner.nextLine();

        if (!password.equals(ADMIN_PASSWORD)) {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
            return;
        }

        System.out.println("Bienvenido al modo administrador.");
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
}

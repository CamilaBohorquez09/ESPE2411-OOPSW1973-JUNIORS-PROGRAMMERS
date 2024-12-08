package espe.edu.ec.model;

import espe.edu.ec.utils.ManageFileCsv;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Validations;
import java.util.Map;
import java.util.Scanner;

public class Cashier {

    public void startOrder(Scanner scanner) {
        Customer customer = getCustomerDetails(scanner);
        if (customer == null) return;

        // Realizar pedido
        Order order = new Order();
        Map<MenuItem, Integer> orderDetails = order.makeOrder(scanner);
        float total = new Counter().calculateTotal(orderDetails);

        // Método de pago
        MethodOfPayment methodOfPayment = new MethodOfPayment();
        methodOfPayment.processPayment(total, scanner);

        // Emisión de comprobante
        System.out.println("¿Desea una factura o nota de venta?");
        System.out.println("1. Factura");
        System.out.println("2. Nota de Venta");
        int option = Validations.validarOpcion(1, 2, scanner);

        if (option == 1) {
            Bill bill = new Bill(customer, orderDetails, total);
            bill.printBill();

            // Guardar factura en JSON
            ManageFileJson manageFileJson = new ManageFileJson();
            manageFileJson.saveBillToJson(bill);

        } else {
            SaleNote saleNote = new SaleNote(customer, orderDetails, total);
            saleNote.printNote();

            // Guardar nota de venta en JSON
            ManageFileJson manageFileJson = new ManageFileJson();
            manageFileJson.saveSaleNoteToJson(saleNote);
        }

        // Guardar datos en archivo CSV
        ManageFileCsv.saveOrderToCsv(customer, orderDetails, total);

        System.out.println("Pedido realizado con éxito.");
    }

    private Customer getCustomerDetails(Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese su cédula: ");
        String cedula = scanner.nextLine();
        if (!Validations.validarCedula(cedula)) {
            System.out.println("Cédula inválida.");
            return null;  // Maneja el caso de cédula inválida
        }

        System.out.print("Ingrese su correo: ");
        String email = scanner.nextLine();
        if (!Validations.validarCorreo(email)) {
            System.out.println("Correo inválido.");
            return null;  // Maneja el caso de correo inválido
        }

        System.out.print("Ingrese su dirección: ");
        String address = scanner.nextLine();

        System.out.print("Ingrese su teléfono: ");
        String phone = scanner.nextLine();
        if (!Validations.validarTelefono(phone)) {
            System.out.println("Teléfono inválido.");
            return null;  // Maneja el caso de teléfono inválido
        }

        return new Customer(name, cedula, email, address, phone);
    }
}

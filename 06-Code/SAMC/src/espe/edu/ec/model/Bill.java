package espe.edu.ec.model;

public class Bill {

    // Método para imprimir la factura, que recibe el cliente, el artículo y la cantidad
    public static void printBill(Customer customer, MenuItem item, int quantity) {
        double total = item.getPrice() * quantity; // Calcula el total del pedido
        System.out.println("******** FACTURA ********");
        System.out.println("Artículo: " + item.getName());
        System.out.println("Descripción: " + item.getDescription());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Precio Unitario: $" + item.getPrice());
        System.out.println("Total: $" + total);
        System.out.println("Datos del cliente:");
        System.out.println("Nombre: " + customer.getName());
        System.out.println("Cédula: " + customer.getIdCard());
        System.out.println("Correo: " + customer.getEmail());
        System.out.println("Dirección: " + customer.getAddress());
        System.out.println("Teléfono: " + customer.getPhoneNumber());
        System.out.println("**************************");
    }
}
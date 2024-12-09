package espe.edu.ec.model;

public class Bill {

    public static void printBill(Customer customer, MenuItem item, int quantity) {
        double total = item.getPrice() * quantity; 
        System.out.println("********** FACTURA ***********");
        System.out.println("Combo: " + item.getName());
        System.out.println("Descripcion: " + item.getDescription());
        System.out.println("Cantidad: " + quantity);
        System.out.println("Precio Unitario: $" + item.getPrice());
        System.out.println("Total: $" + total);
        System.out.println("Datos del cliente:");
        System.out.println("Nombre: " + customer.getName());
        System.out.println("Cedula: " + customer.getIdCard());
        System.out.println("Correo: " + customer.getEmail());
        System.out.println("Direccion: " + customer.getAddress());
        System.out.println("Teléfono: " + customer.getPhoneNumber());
        System.out.println("**************************");
    }
}
package espe.edu.ec.model;

import java.util.Map;

public class SaleNote {
    private Customer customer;
    private Map<MenuItem, Integer> orderDetails;
    private float total;

    public SaleNote(Customer customer, Map<MenuItem, Integer> orderDetails, float total) {
        this.customer = customer;
        this.orderDetails = orderDetails;
        this.total = total;
    }

    public void printNote() {
        System.out.println("Nota de venta:");
        System.out.println("Nombre: " + customer.getName());
        System.out.println("Cédula: " + customer.getCedula());
        System.out.println("Correo: " + customer.getEmail());
        System.out.println("Dirección: " + customer.getAddress());
        System.out.println("Teléfono: " + customer.getPhone());
        System.out.println("Detalles del pedido:");
        for (Map.Entry<MenuItem, Integer> entry : orderDetails.entrySet()) {
            System.out.println(entry.getKey().getName() + " - Cantidad: " + entry.getValue() + " - Precio: " + entry.getKey().getPrice());
        }
        System.out.println("Total a pagar: " + total);
    }
}

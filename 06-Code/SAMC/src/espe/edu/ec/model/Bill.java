package espe.edu.ec.model;

import java.util.Map;

public class Bill {
    private Customer customer;
    private Map<String, Integer> order;
    private float total;

    public Bill(Customer customer, Map<String, Integer> order, float total) {
        this.customer = customer;
        this.order = order;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Cliente: " + customer +
                ", Platos Pedidos: " + order +
                ", Total: $" + total +
                '}';
    }
}

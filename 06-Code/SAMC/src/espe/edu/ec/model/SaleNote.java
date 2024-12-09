package espe.edu.ec.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SaleNote {
    private Customer customer;
    private Map<String, Integer> order;
    private float total;
    private String date;
    

    public SaleNote(Customer customer, Map<String, Integer> order, float total) {
        this.customer = customer;
        this.order = order;
        this.total = total;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<String, Integer> getOrder() {
        return order;
    }

    public float getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }
    public String getOrderDetails() {
    StringBuilder details = new StringBuilder();
    for (Map.Entry<String, Integer> entry : order.entrySet()) {
        MenuItem item = MenuItem.getMenuItemById(getMenuItemIdByName(entry.getKey()));
        if (item != null) {
            details.append(String.format("Nombre: %s, Descripcion: %s, Precio: %.2f, Cantidad: %d\n",
                    item.getName(), item.getDescription(), item.getPrice(), entry.getValue()));
        }
    }
    return details.toString();
    }

    private int getMenuItemIdByName(String name) {
    for (MenuItem item : MenuItem.getMenuItems()) {
        if (item.getName().equalsIgnoreCase(name)) {
            return item.getId();
        }
    }
    return -1;
    }
    @Override
    public String toString() {
    return "NOTA DE VENTA\n" +
           "-------------------------------------------\n" +
           "Cliente: " + customer.getName() + "\n" +
           "Cedula: " + customer.getIdCard() + "\n" +
           "Fecha: " + date + "\n" +
           "-------------------------------------------\n" +
           "Detalles del Pedido:\n" + getOrderDetails() +
           "-------------------------------------------\n" +
           "Total: $" + total;
}
}
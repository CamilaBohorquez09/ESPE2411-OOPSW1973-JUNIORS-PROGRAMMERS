package espe.edu.ec.model;

import espe.edu.ec.utils.ManageFileJson;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class Bill {
    private Customer customer;
    private Map<String, Integer> order;
    private float total;
    private String date;

    public Bill(Customer customer, Map<String, Integer> order, float total) {
        this.customer = customer;
        this.order = order;
        this.total = total;
        this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


    public String getDate() {
        return date;
    }
       public void printBill(Scanner scanner, ManageFileJson manageFileJson) {
        System.out.print("Ingrese su cedula: ");
        String idCard = scanner.nextLine();

        Customer customer = manageFileJson.getCustomerById(idCard);

        if (customer == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Map<String, Integer> order = manageFileJson.getOrderByCustomer(idCard);

        if (order.isEmpty()) {
            System.out.println("No se encontraron pedidos para este cliente.");
            return;
        }

        float total = new Counter().calculateTotal(order);
        Bill bill = new Bill(customer, order, total);
        manageFileJson.saveBillToJson(bill);

        System.out.println(bill);
    }

    private float calculateTotal() {
        float total = 0.0f;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            MenuItem item = MenuItem.getMenuItemById(getMenuItemIdByName(entry.getKey()));
            if (item != null) {
                total += item.getPrice() * entry.getValue();
            }
        }
        return total;
    }
    
    private int getMenuItemIdByName(String name) {
        for (MenuItem item : MenuItem.getMenuItems()) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item.getId();
            }
        }
        return -1;
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
    public String getCustomerDetails() {
    return String.format("ID: %s\nNombre: %s\nEmail: %s\nDireccion: %s\nTelefono: %s",
            customer.getIdCard(),
            customer.getName(),
            customer.getEmail(),
            customer.getAddress(),
            customer.getPhoneNumber());
}
     @Override
    public String toString() {
        return "FACTURA\n" +
                "-------------------------------------------\n" +
                "Informacion del Cliente:\n" +
                "Nombre: " + customer.getName() + "\n" +
                "Cedula: " + customer.getIdCard() + "\n" +
                "Telefono: " + customer.getPhoneNumber() + "\n" +
                "Direccion: " + customer.getAddress() + "\n" +
                "Correo: " + customer.getEmail() + "\n" +
                "Fecha: " + date + "\n" +
                "-------------------------------------------\n" +
                "Detalles del Pedido:\n" 
                +getOrderDetails()+ 
                "-------------------------------------------\n" +
                "Total: $" + total;
    }
}
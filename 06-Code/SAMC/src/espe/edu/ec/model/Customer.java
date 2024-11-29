package espe.edu.ec.model;

import java.util.List;

/**
 * Clase que representa un cliente en el restaurante.
 */
public class Customer {
    private String name;
    private int id;
    private String email;
    private String address;
    private String phoneNumber;
    private List<Order> orders;

    public Customer(String name, int id, String email, String address, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder ordersDetails = new StringBuilder();
        if (orders != null) {
            for (Order order : orders) {
                ordersDetails.append(order).append("\n");
            }
        }
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orders=\n" + ordersDetails +
                '}';
    }

    // Métodos vacíos para implementar en el futuro

    /**
     * Agrega una nueva orden al cliente.
     *
     * @param order La orden que se va a agregar.
     */
    public void addOrder(Order order) {
        // Implementación futura
    }

    /**
     * Calcula el total gastado por el cliente en todas sus órdenes.
     *
     * @return El total calculado.
     */
    public float calculateTotalSpent() {
        // Implementación futura
        return 0.0f;
    }

    /**
     * Obtiene las órdenes activas (no pagadas) del cliente.
     *
     * @return Lista de órdenes activas.
     */
    public List<Order> getActiveOrders() {
        // Implementación futura
        return null;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setters
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}

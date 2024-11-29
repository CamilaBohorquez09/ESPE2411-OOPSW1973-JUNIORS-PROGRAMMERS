package espe.edu.ec.model;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa una orden en un restaurante.
 */
public class Order {
    private int orderId;
    private String customerName;
    private List<MenuItem> orderedItems;
    private String tableNumber;
    private Date orderDate;
    private SaleNote saleNote;

    public Order(int orderId, String customerName, List<MenuItem> orderedItems, 
                 String tableNumber, Date orderDate, SaleNote saleNote) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderedItems = orderedItems;
        this.tableNumber = tableNumber;
        this.orderDate = orderDate;
        this.saleNote = saleNote;
    }

    @Override
    public String toString() {
        StringBuilder itemsDetails = new StringBuilder();
        for (MenuItem item : orderedItems) {
            itemsDetails.append(item).append("\n");
        }
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", orderedItems=\n" + itemsDetails +
                ", tableNumber='" + tableNumber + '\'' +
                ", orderDate=" + orderDate +
                ", saleNote=" + saleNote +
                '}';
    }

    // Métodos vacíos para implementar en el futuro

    /**
     * Calcula el total de la orden basándose en los ítems ordenados.
     *
     * @return El total calculado.
     */
    public float calculateOrderTotal() {
        // Implementación futura
        return 0.0f;
    }

    /**
     * Asigna la orden a un número de mesa específico.
     *
     * @param tableNumber El número de la mesa.
     */
    public void assignTable(String tableNumber) {
        // Implementación futura
    }

    /**
     * Procesa el pago de la orden.
     *
     * @param paymentMethod El método de pago (Efectivo, Tarjeta, etc.).
     * @return true si el pago fue exitoso, de lo contrario false.
     */
    public boolean processPayment(String paymentMethod) {
        // Implementación futura
        return false;
    }

    // Getters y Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<MenuItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<MenuItem> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public SaleNote getSaleNote() {
        return saleNote;
    }

    public void setSaleNote(SaleNote saleNote) {
        this.saleNote = saleNote;
    }
}
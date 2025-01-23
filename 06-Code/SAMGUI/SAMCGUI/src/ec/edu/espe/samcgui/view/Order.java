package ec.edu.espe.samcgui.view;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private String customerId;
    private String customerEmail;
    private String customerContactNumber;
    private String customerAddress;
    private List<Dish> dishes;

    public Order(String customerName, String customerId, String customerEmail, String customerContactNumber, String customerAddress) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.customerContactNumber = customerContactNumber;
        this.customerAddress = customerAddress;
        this.dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish);
    }

    // Getters y setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(String customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }
    
    public String getCustomerAddress() {
        return customerContactNumber;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}

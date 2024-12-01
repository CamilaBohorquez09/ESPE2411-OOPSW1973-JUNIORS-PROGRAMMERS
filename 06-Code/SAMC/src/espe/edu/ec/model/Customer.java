package espe.edu.ec.model;

import java.util.List;

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

    // Getters and Setters
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
}

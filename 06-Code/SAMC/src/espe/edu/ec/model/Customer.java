package espe.edu.ec.model;

public class Customer {
    private String name;
    private String cedula;
    private String email;
    private String address;
    private String phone;

    public Customer(String name, String cedula, String email, String address, String phone) {
        this.name = name;
        this.cedula = cedula;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}

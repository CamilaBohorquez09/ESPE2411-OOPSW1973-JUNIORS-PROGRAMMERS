package espe.edu.ec.model;

/**
 * Clase que representa los datos del cliente.
 */
public class Cashier {
    private int dniCustomer;
    private String nameCustomer;
    private String addressOfCustomer;
    private String emailOfCustomer;
    private String phoneOfCustomer;

    @Override
    public String toString() {
        return "Cashier{" + "dniCustomer=" + dniCustomer + ", nameCustomer=" 
                + nameCustomer + ", addressOfCustomer=" + addressOfCustomer 
                + ", emailOfCustomer=" + emailOfCustomer + ", phoneOfCustomer=" 
                + phoneOfCustomer + '}';
    }

    // Getters and Setters
    public int getDniCustomer() {
        return dniCustomer;
    }

    public void setDniCustomer(int dniCustomer) {
        this.dniCustomer = dniCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddressOfCustomer() {
        return addressOfCustomer;
    }

    public void setAddressOfCustomer(String addressOfCustomer) {
        this.addressOfCustomer = addressOfCustomer;
    }

    public String getEmailOfCustomer() {
        return emailOfCustomer;
    }

    public void setEmailOfCustomer(String emailOfCustomer) {
        this.emailOfCustomer = emailOfCustomer;
    }

    public String getPhoneOfCustomer() {
        return phoneOfCustomer;
    }

    public void setPhoneOfCustomer(String phoneOfCustomer) {
        this.phoneOfCustomer = phoneOfCustomer;
    }
}



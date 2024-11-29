package espe.edu.ec.model;

/**
 * Clase que representa una factura.
 */
public class Bill {
    private Cashier cashier;

    public Bill(Cashier cashier) {
        this.cashier = cashier;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "dniCustomer=" + cashier.getDniCustomer() +
                ", nameCustomer='" + cashier.getNameCustomer() + '\'' +
                ", addressOfCustomer='" + cashier.getAddressOfCustomer() + '\'' +
                ", emailOfCustomer='" + cashier.getEmailOfCustomer() + '\'' +
                ", phoneOfCustomer='" + cashier.getPhoneOfCustomer() + '\'' +
                '}';
    }
  // Additional methods for processing the bill can be added here

    public Cashier getCashier(Order order) {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
    
}

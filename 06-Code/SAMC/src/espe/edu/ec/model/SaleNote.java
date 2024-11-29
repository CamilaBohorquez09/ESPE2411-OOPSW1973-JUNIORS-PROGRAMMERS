package espe.edu.ec.model;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa una Nota de Venta.
 */
public class SaleNote {
    private String saleNoteNumber;
    private Date date;
    private String customerName;
    private List<MenuItem> products;
    private double tax;
    private double totalAmount;
    private String paymentMethod;

    public SaleNote(String saleNoteNumber, Date date, String customerName, 
                    List<MenuItem> products, double tax, double totalAmount, String paymentMethod) {
        this.saleNoteNumber = saleNoteNumber;
        this.date = date;
        this.customerName = customerName;
        this.products = products;
        this.tax = tax;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        StringBuilder productDetails = new StringBuilder();
        for (MenuItem product : products) {
            productDetails.append(product).append("\n");
        }
        return "SaleNote{" +
                "saleNoteNumber='" + saleNoteNumber + '\'' +
                ", date=" + date +
                ", customerName='" + customerName + '\'' +
                ", products=\n" + productDetails.toString() +
                ", tax=" + tax +
                ", totalAmount=" + totalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    // Getters y Setters
    public String getSaleNoteNumber() {
        return saleNoteNumber;
    }

    public void setSaleNoteNumber(String saleNoteNumber) {
        this.saleNoteNumber = saleNoteNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<MenuItem> getProducts() {
        return products;
    }

    public void setProducts(List<MenuItem> products) {
        this.products = products;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
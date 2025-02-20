package ec.edu.espe.samc.model;

import java.util.Map;

public abstract class TransactionReceipt {

    protected Customer customer;
    protected Map<String, Integer> order;
    protected float total;
    protected String date;

    public TransactionReceipt(Customer customer, Map<String, Integer> order, float total, String date) {
        this.customer = customer;
        this.order = order;
        this.total = total;
        this.date = date;
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

    @Override
    public abstract String toString();
}

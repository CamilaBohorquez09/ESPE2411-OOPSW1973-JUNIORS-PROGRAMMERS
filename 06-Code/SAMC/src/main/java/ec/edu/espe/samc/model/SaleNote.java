package ec.edu.espe.samc.model;

import ec.edu.espe.samc.utils.ReceiptFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SaleNote extends TransactionReceipt {

    public SaleNote(Customer customer, Map<String, Integer> order, float total) {
        super(customer, order, total, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Override
    public String toString() {
        return ReceiptFormatter.formatReceipt(this);
    }
}

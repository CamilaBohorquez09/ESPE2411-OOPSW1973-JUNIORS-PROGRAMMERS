package ec.edu.espe.samc.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Bill extends TransactionReceipt {

    public Bill(Customer customer, Map<String, Integer> order, float total) {
        super(customer, order, total, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("----- Factura -----\n");
        receipt.append("Fecha: ").append(getDate()).append("\n");
        receipt.append("Cliente: ").append(getCustomer().getName()).append("\n");
        receipt.append("Correo: ").append(getCustomer().getEmail()).append("\n");
        receipt.append("Teléfono: ").append(getCustomer().getPhoneNumber()).append("\n");
        receipt.append("Dirección: ").append(getCustomer().getAddress()).append("\n");
        receipt.append("----- Pedido -----\n");

        for (Map.Entry<String, Integer> entry : getOrder().entrySet()) {
            receipt.append(" - Platillo: ").append(entry.getKey())
                    .append(", Cantidad: ").append(entry.getValue()).append("\n");
        }

        receipt.append("----- Total -----\n");
        receipt.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        return receipt.toString();
    }
}

package ec.edu.espe.samc.utils;

import ec.edu.espe.samc.model.TransactionReceipt;
import java.util.Map;

public class ReceiptFormatter {

    public static String formatReceipt(TransactionReceipt receipt) {
        StringBuilder note = new StringBuilder();
        note.append("----- Nota de Venta -----\n");

        for (Map.Entry<String, Integer> entry : receipt.getOrder().entrySet()) {
            note.append(" - Platillo: ").append(entry.getKey())
                    .append(", Cantidad: ").append(entry.getValue()).append("\n");
        }

        note.append("----- Total -----\n");
        note.append("Total: $").append(String.format("%.2f", receipt.getTotal())).append("\n");

        return note.toString();
    }
}

package espe.edu.ec.utils;

import espe.edu.ec.model.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ManageFileCsv {

    public void saveOrderToCsv(Order order) {
        String fileName = "orders.csv";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(String.valueOf(order.getOrderId()));
            writer.append(",");
            writer.append(order.getCustomerName());
            writer.append(",");
            writer.append(order.getTableNumber());
            writer.append(",");
            writer.append(String.valueOf(order.getOrderDate()));
            writer.append(",");

            Map<String, Integer> items = order.getItems();
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                writer.append(entry.getKey());
                writer.append(":");
                writer.append(String.valueOf(entry.getValue()));
                writer.append(";");
            }
            writer.append("\n");
            System.out.println("Pedido guardado en CSV exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el pedido en el archivo CSV: " + e.getMessage());
        }
    }
}

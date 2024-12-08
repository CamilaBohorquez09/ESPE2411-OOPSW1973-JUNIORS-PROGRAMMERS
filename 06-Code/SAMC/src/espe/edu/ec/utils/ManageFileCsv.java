package espe.edu.ec.utils;

import espe.edu.ec.model.Customer;
import espe.edu.ec.model.MenuItem;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ManageFileCsv {

    public static void saveOrderToCsv(Customer customer, Map<MenuItem, Integer> orderDetails, float total) {
        try (FileWriter writer = new FileWriter("orders.csv", true)) {
            writer.append(customer.getName())
                    .append(",").append(customer.getCedula())
                    .append(",").append(customer.getEmail())
                    .append(",").append(customer.getAddress())
                    .append(",").append(customer.getPhone())
                    .append(",").append(String.valueOf(total))
                    .append("\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el pedido en CSV.");
        }
    }
}

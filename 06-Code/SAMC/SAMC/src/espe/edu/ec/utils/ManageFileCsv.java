package espe.edu.ec.utils;

import espe.edu.ec.model.Cashier;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ManageFileCsv {
    private static final String FILE_NAME = "sales.csv";

    public void saveToCsv(Cashier cashier, Map<String, Integer> order, float totalToPay) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = dateFormat.format(new Date());

            writer.append(cashier.getCustomer().getName()).append(",");
            writer.append(String.valueOf(cashier.getCustomer().getIdCard())).append(",");
            writer.append(cashier.getCustomer().getEmail()).append(",");
            writer.append(cashier.getCustomer().getPhoneNumber()).append(",");

            StringBuilder dishes = new StringBuilder();
            StringBuilder quantities = new StringBuilder();
            for (Map.Entry<String, Integer> entry : order.entrySet()) {
                dishes.append(entry.getKey()).append(";");
                quantities.append(entry.getValue()).append(";");
            }

            writer.append(dishes.toString()).append(",");
            writer.append(quantities.toString()).append(",");
            writer.append(date).append(",");
            writer.append(String.valueOf(totalToPay)).append("\n");

            System.out.println("Datos guardados en el archivo CSV.");
        } catch (IOException e) {
            System.out.println("Error al guardar en CSV: " + e.getMessage());
        }
    }
}

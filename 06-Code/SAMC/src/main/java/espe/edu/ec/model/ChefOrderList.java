package espe.edu.ec.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChefOrderList {
    private final Gson gson;

    public ChefOrderList() {
        this.gson = new Gson();
    }

    private Map<String, Integer> getAllOrders() {
        Map<String, Integer> aggregatedOrders = new HashMap<>();

        try (FileReader reader = new FileReader("bills.json")) {
            List<Bill> bills = gson.fromJson(reader, new TypeToken<List<Bill>>() {}.getType());

            if (bills != null) {
                for (Bill bill : bills) {
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo bills.json: " + e.getMessage());
        }

        return aggregatedOrders;
    }

    public void displayOrderedDishes() {
        Map<String, Integer> allOrders = getAllOrders();

        if (allOrders.isEmpty()) {
            System.out.println("No hay platos pendientes para preparar.");
            return;
        }

        System.out.println("=== Platos a preparar ===");
        for (Map.Entry<String, Integer> entry : allOrders.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

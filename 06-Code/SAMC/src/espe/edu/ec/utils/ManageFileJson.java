package espe.edu.ec.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import espe.edu.ec.model.Customer;
import espe.edu.ec.model.MenuItem;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageFileJson {
    private final Gson gson;
    private final DateTimeFormatter formatter;

    public ManageFileJson() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    // Guardar la venta con datos del cliente, los productos comprados y la hora
    public void saveTransactionToJson(Customer customer, Map<String, Integer> order) {
        List<Map<String, Object>> transactions = new ArrayList<>();
        
        try (FileReader reader = new FileReader("transactions.json")) {
            transactions = gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
            if (transactions == null) {
                transactions = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo transactions.json, se creará uno nuevo.");
        }

        // Crear un mapa con la transacción que se va a agregar
        Map<String, Object> transactionData = new HashMap<>();
        transactionData.put("customerName", customer.getName());
        transactionData.put("customerId", customer.getIdCard());
        transactionData.put("order", order);
        transactionData.put("timestamp", LocalDateTime.now().format(formatter));

        transactions.add(transactionData);

        // Guardar la lista de transacciones actualizada en el archivo JSON
        try (FileWriter writer = new FileWriter("transactions.json")) {
            gson.toJson(transactions, writer);
            System.out.println("Transacción guardada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la transacción en JSON: " + e.getMessage());
        }
    }

    // Obtener las transacciones guardadas
    public List<Map<String, Object>> getTransactions() {
        List<Map<String, Object>> transactions = new ArrayList<>();
        try (FileReader reader = new FileReader("transactions.json")) {
            transactions = gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
            if (transactions == null) {
                transactions = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo transactions.json: " + e.getMessage());
        }
        return transactions;
    }

    // Guardar la cantidad de productos en el inventario
    public void saveQuantitiesToJson() {
        List<Map<String, Object>> quantities = new ArrayList<>();
        for (MenuItem item : MenuItem.getMenuItems()) {
            Map<String, Object> itemData = new HashMap<>();
            itemData.put("id", item.getId());
            itemData.put("name", item.getName());
            itemData.put("quantity", item.getInventory());
            quantities.add(itemData);
        }
        try (FileWriter writer = new FileWriter("quantity.json")) {
            gson.toJson(quantities, writer);
            System.out.println("Inventario guardado correctamente en quantity.json.");
        } catch (IOException e) {
            System.out.println("Error al guardar quantity.json: " + e.getMessage());
        }
    }

    // Cargar las cantidades de productos desde el archivo JSON
    public void loadQuantitiesFromJson() {
        try (FileReader reader = new FileReader("quantity.json")) {
            List<Map<String, Object>> quantities = gson.fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
            if (quantities != null) {
                for (Map<String, Object> itemData : quantities) {
                    int id = ((Double) itemData.get("id")).intValue();
                    int quantity = ((Double) itemData.get("quantity")).intValue();
                    MenuItem item = MenuItem.getMenuItemById(id);
                    if (item != null) {
                        item.reduceInventory(item.getInventory() - quantity);
                    }
                }
            }
            System.out.println("Inventario cargado desde quantity.json.");
        } catch (IOException e) {
            System.out.println("Error al cargar quantity.json: " + e.getMessage());
        }
    }
}
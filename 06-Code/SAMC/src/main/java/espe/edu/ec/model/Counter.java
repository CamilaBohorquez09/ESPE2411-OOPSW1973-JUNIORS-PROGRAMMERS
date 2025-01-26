package espe.edu.ec.model;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.controller.MongoDBManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class Counter {

    public float calculateTotal(Map<String, Integer> order, List<MenuItem> menuItems) {
        float total = 0.0f;
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            MenuItem item = MenuItem.getMenuItemByName(entry.getKey(), menuItems);
            if (item != null) {
                total += item.getPrice() * entry.getValue();
            }
        }
        return total;
    }

    public static List<MenuItem> loadMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        MongoClient client = MongoDBManager.getMongoClient();

        if (client == null) {
            return menuItems;
        }

        MongoDatabase database = client.getDatabase("bd_restaurante");
        MongoCollection<Document> collection = database.getCollection("comida");
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            int id = doc.getInteger("ID");
            String name = doc.getString("Nombre");
            String descrition = doc.getString("Descripcion");
            Number price = doc.get("Precio", Number.class);
            float priceFloat = price != null ? price.floatValue() : 0f;
            int inventory = doc.getInteger("Inventario");
            MenuItem menuItem = new MenuItem(id, name, descrition, priceFloat, inventory);
            menuItems.add(menuItem);
        }
        return menuItems;
    }

    private int getMenuItemIdByName(String name) {
//        for (MenuItem item : MenuItem.getMenuItems()) {
//            if (item.getName().equalsIgnoreCase(name)) {
//                return item.getId();
//            }
//        }
        return -1;
    }
}

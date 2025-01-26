package espe.edu.ec.model;

import java.util.List;

public class MenuItem {

//    private static List<MenuItem> menuItems = new ArrayList<>();
    private String name;
    private String description;
    private float price;
    private int id;
    private int inventory;

    public MenuItem(int id, String name, String description, float price, int inventory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
    }

    public static MenuItem getMenuItemById(int id, List<MenuItem> menuItems) {
        for (MenuItem item : menuItems) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

    public static MenuItem getMenuItemByName(String name, List<MenuItem> menuItems) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getInventory() {
        return inventory;
    }

    public int getId() {
        return id;
    }
}

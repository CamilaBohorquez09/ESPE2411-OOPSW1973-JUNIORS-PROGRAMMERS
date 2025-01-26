package espe.edu.ec.model;

import java.util.ArrayList;
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
//        menuItems.add(this);
    }



    public static void displayMenu(List<MenuItem> menuItems) {
        System.out.println("\n+----+----------------------+--------------------------------------------+---------+------------+");
        System.out.printf("| %-2s | %-20s | %-44s | %-7s | %-10s |\n", "ID", "Nombre", "Descripcion", "Precio", "Inventario");
        System.out.println("+----+----------------------+--------------------------------------------+---------+------------+");

        for (MenuItem item : menuItems) {
            System.out.printf("| %-2d | %-20s | %-44s | $%-6.2f | %-10d |\n",
                    item.id,
                    item.name,
                    item.description,
                    item.price,
                    item.inventory);
        }
        System.out.println("+----+----------------------+--------------------------------------------+---------+------------+\n");
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

    public void reduceInventory(int quantity) {
        if (quantity <= inventory) {
            inventory -= quantity;
        } else {
            System.out.println("No hay suficiente inventario para " + name);
        }
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

//    public static List<MenuItem> getMenuItems() {
//        return menuItems;
//    }

    public int getId() {
        return id;
    }
}

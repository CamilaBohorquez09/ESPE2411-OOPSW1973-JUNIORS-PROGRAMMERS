package espe.edu.ec.model;

import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private int id;
    private String name;
    private String description;
    private float price;

    private static List<MenuItem> menu = new ArrayList<>();

    static {
        menu.add(new MenuItem(1, "Salchichas", "Deliciosas salchichas con papas", 5.0f));
        menu.add(new MenuItem(2, "Pollo", "Pollo asado con ensalada", 7.5f));
        menu.add(new MenuItem(3, "Carne", "Carne a la parrilla con arroz", 10.0f));
    }

    public MenuItem(int id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static void displayMenu() {
        System.out.println("Menú disponible:");
        for (MenuItem item : menu) {
            System.out.println(item.id + ". " + item.name + " - $" + item.price + " (" + item.description + ")");
        }
    }

    public static MenuItem getMenuItemById(int id) {
        for (MenuItem item : menu) {
            if (item.id == id) {
                return item;
            }
        }
        return null;
    }

    public float getPrice() {
        return price;
    }
}
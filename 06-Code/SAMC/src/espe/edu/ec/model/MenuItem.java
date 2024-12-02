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
    menu.add(new MenuItem(1, "Guata pequenia", "Plato tradicional de guata", 1.50f));
    menu.add(new MenuItem(2, "Guata mediana", "Plato tradicional de guata", 2.00f));
    menu.add(new MenuItem(3, "Guata extragrande", "Plato tradicional de guata", 2.50f));
    menu.add(new MenuItem(4, "Papas con cuero", "Papas con cuero", 2.00f));
    menu.add(new MenuItem(5, "Seco de chivo", "Plato con carne de chivo", 2.50f));
    menu.add(new MenuItem(6, "Seco de chancho", "Plato con carne de chancho", 2.50f));
    menu.add(new MenuItem(7, "Seco de costilla", "Plato con costilla", 2.50f));
    menu.add(new MenuItem(8, "Seco de pollo", "Plato con carne de pollo", 2.50f));
    menu.add(new MenuItem(9, "Mixto seco de pollo y guata", "Mezcla de pollo y guata", 3.50f));
    menu.add(new MenuItem(10, "Mixto seco de costilla y guata", "Mezcla de costilla y guata", 3.50f));
    menu.add(new MenuItem(11, "Mixto papas con cuero y guata", "Mezcla de papas con cuero y guata", 3.50f));
    menu.add(new MenuItem(12, "Mixto seco de chivo y guata", "Mezcla de chivo y guata", 3.50f));
    menu.add(new MenuItem(13, "Mixto seco de chancho y guata", "Mezcla de chancho y guata", 3.50f));
    menu.add(new MenuItem(14, "Mixto seco de pollo y papas con cuero", "Mezcla de pollo y papas con cuero", 3.50f));
    menu.add(new MenuItem(15, "Mixto seco de chancho y papas con cuero", "Mezcla de chancho y papas con cuero", 3.50f));
    menu.add(new MenuItem(16, "Mixto seco de costilla y papas con cuero", "Mezcla de costilla y papas con cuero", 3.50f));
    menu.add(new MenuItem(17, "Mixto seco de chivo y papas con cuero", "Mezcla de chivo y papas con cuero", 3.50f));
    menu.add(new MenuItem(18, "Mixto con doble carne; pollo, chivo, chancho, costilla", "Plato con doble carne", 4.50f));
    menu.add(new MenuItem(19, "Banderas", "Plato especial de banderas", 6.75f));
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
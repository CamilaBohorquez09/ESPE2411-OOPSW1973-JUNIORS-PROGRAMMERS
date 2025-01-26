package espe.edu.ec.model;

import java.util.HashMap;
import java.util.Map;

public class Dish {
    private String name;
    private int quantity;
    private double price;

    // Mapa estático para gestionar los platillos en la orden
    private static Map<String, Dish> dishes = new HashMap<>();

    public Dish(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    // Métodos estáticos para gestionar los platillos

    // Buscar un platillo por nombre
    public static Dish getDishByName(String name) {
        return dishes.get(name); // Retorna el platillo si existe, o null si no
    }

    // Agregar o actualizar un platillo en la orden
    public static void addDish(Dish dish) {
        if (dishes.containsKey(dish.getName())) {
            Dish existingDish = dishes.get(dish.getName());
            existingDish.setQuantity(existingDish.getQuantity() + dish.getQuantity());
        } else {
            dishes.put(dish.getName(), dish);
        }
    }

    // Obtener todos los platillos en la orden
    public static Map<String, Dish> getDishes() {
        return dishes;
    }

    // Método para limpiar todos los platillos (opcional)
    public static void clearDishes() {
        dishes.clear();
    }
}

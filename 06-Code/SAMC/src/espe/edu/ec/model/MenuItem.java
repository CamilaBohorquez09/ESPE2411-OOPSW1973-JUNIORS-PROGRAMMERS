package espe.edu.ec.model;

/**
 * Clase que representa un Producto en una Nota de Venta.
 */
public class MenuItem {
    private int id;
    private String name;
    private String description;
    private float price;
    private boolean isAvailable;

    public MenuItem(int id, String name, String description, float price, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }

    // Getters y Setters
    public int getId(DrinksInventory drinksinventory) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(DishInventory dishinventory) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
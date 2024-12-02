package espe.edu.ec.model;

import java.util.Map;

public class Counter {

    public float calculateTotal(Map<Integer, Integer> order) {
        float total = 0.0f;

        for (Map.Entry<Integer, Integer> entry : order.entrySet()) {
            int dishId = entry.getKey();
            int quantity = entry.getValue();

            MenuItem menuItem = MenuItem.getMenuItemById(dishId);
            if (menuItem != null) {
                total += menuItem.getPrice() * quantity;
            }
        }

        return total;
    }
}

package espe.edu.ec.model;

import java.util.Map;

public class Counter {

    public float calculateTotal(Map<MenuItem, Integer> order) {
        float total = 0;
        for (Map.Entry<MenuItem, Integer> entry : order.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getPrice() * quantity;
        }
        return total;
    }
}

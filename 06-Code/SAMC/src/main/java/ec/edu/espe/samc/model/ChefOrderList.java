package ec.edu.espe.samc.model;

import java.util.HashMap;
import java.util.Map;

public class ChefOrderList {

    public static  String generateOrderList(HashMap<String, Integer> platillosMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------Platillos a preparar--------------:\n");
        for (Map.Entry<String, Integer> entry : platillosMap.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}

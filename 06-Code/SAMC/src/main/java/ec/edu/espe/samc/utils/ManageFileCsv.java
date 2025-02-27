package ec.edu.espe.samc.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class ManageFileCsv {
    private static final String JSON_FILE_PATH = "AgachaditosJavi.json";
    private static final String CSV_FILE_PATH = "AgachaditosJavi.csv";

    public static void saveJsonDataToCsv() {
        Gson gson = new Gson();
        
        try (FileReader reader = new FileReader(JSON_FILE_PATH);
             FileWriter writer = new FileWriter(CSV_FILE_PATH)) {
            
            Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
            List<Map<String, Object>> data = gson.fromJson(reader, listType);
            
            if (data == null || data.isEmpty()) {
                System.out.println("No hay datos en el archivo JSON.");
                return;
            }
            
            // Escribir encabezados
            Map<String, Object> firstRow = data.get(0);
            writer.append(String.join(",", firstRow.keySet())).append("\n");
            
            // Escribir datos
            for (Map<String, Object> row : data) {
                writer.append(String.join(",", row.values().stream()
                        .map(String::valueOf)
                        .toArray(String[]::new)))
                        .append("\n");
            }
            
            System.out.println("Datos guardados en " + CSV_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al leer/escribir archivo: " + e.getMessage());
        }
    }
}

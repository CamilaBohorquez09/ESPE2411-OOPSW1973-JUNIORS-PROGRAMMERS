package espe.edu.ec.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import espe.edu.ec.model.Cashier;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase para manejar operaciones relacionadas con archivos JSON usando Gson.
 */
public class ManageFileJson {
    private static final String FILE_NAME = "customers.json";

    public void saveToJson(Cashier cashier) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            String json = gson.toJson(cashier);
            writer.write(json + "\n");
            System.out.println("Datos guardados en el archivo JSON.");
        } catch (IOException e) {
            System.out.println("Error al guardar en JSON: " + e.getMessage());
        }
    }
}
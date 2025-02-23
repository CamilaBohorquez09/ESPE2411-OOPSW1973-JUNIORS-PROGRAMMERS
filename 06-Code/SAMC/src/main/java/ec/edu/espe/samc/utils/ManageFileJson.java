package ec.edu.espe.samc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.samc.controller.MongoDBManager;
import org.bson.Document;

import java.io.FileWriter;
import java.io.IOException;

public class ManageFileJson {
    private static final String FILE_PATH = "data.json";

    public static void saveMongoDataToJson() {
        MongoDatabase database = MongoDBManager.getInstance().getDatabase();
        if (database == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        MongoCollection<Document> collection = database.getCollection("tu_coleccion");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(FILE_PATH);
             MongoCursor<Document> cursor = collection.find().iterator()) {

            writer.write("[");
            boolean first = true;
            while (cursor.hasNext()) {
                if (!first) {
                    writer.write(",\n");
                }
                writer.write(gson.toJson(cursor.next()));
                first = false;
            }
            writer.write("]");

            System.out.println("Datos guardados en " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo JSON: " + e.getMessage());
        }
    }
}

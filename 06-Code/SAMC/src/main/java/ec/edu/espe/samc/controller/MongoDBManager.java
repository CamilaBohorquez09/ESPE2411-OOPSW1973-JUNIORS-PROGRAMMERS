package ec.edu.espe.samc.controller;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBManager {
    private static MongoClient mongoClient = null;
    private static final String DATABASE_NAME = "bd_restaurante";

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            try {
                MongoClientSettings settings = MongoDBConfig.getMongoClientSettings();
                mongoClient = MongoClients.create(settings);
                System.out.println("Conexión exitosa a MongoDB Atlas.");
            } catch (Exception e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
                return null;
            }
        }
        return mongoClient;
    }

    public static MongoDatabase getDatabase() {
        MongoClient client = getMongoClient();
        return client != null ? client.getDatabase(DATABASE_NAME) : null;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            System.out.println("Conexión cerrada.");
        }
    }

    public static void main(String[] args) {
        MongoDatabase database = getDatabase();
        if (database != null) {
            System.out.println("Base de datos seleccionada: " + database.getName());
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        closeConnection();
    }
}

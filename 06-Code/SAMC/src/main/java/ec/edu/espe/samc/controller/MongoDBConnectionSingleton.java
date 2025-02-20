package ec.edu.espe.samc.controller;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBConnectionSingleton implements DatabaseConnection {
    private static MongoDBConnectionSingleton instance;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private static final String DATABASE_NAME = "bd_restaurante";

    private MongoDBConnectionSingleton() {
        // Configuración de CodecRegistry para POJOs
        MongoClientSettings settings = MongoDBConfig.getMongoClientSettings();
        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase(DATABASE_NAME);
    }

    public static synchronized MongoDBConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new MongoDBConnectionSingleton();
        }
        return instance;
    }

    @Override
    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    @Override
    public void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            System.out.println("Conexión cerrada.");
        }
    }

    public static void main(String[] args) {
        DatabaseConnection dbConnection = MongoDBConnectionSingleton.getInstance();
        MongoDatabase database = dbConnection.getDatabase();
        if (database != null) {
            System.out.println("Base de datos seleccionada: " + database.getName());
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        dbConnection.closeConnection();
    }
}

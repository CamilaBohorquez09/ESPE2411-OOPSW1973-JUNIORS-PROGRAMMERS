package controladores;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ConexionMongo {
    private static MongoClient mongoClient = null;
    
    // URI de conexión a MongoDB Atlas
    private static final String URI = "mongodb+srv://rchapigo:1234@cluster0.0etpp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0/";
    private static final String DATABASE_NAME = "bd_restaurante";

    public static MongoClient getMongoClient() {
        if (mongoClient == null) {
            try {
                CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
                CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
                
                mongoClient = MongoClients.create(
                    MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(URI))
                        .codecRegistry(codecRegistry)
                        .build()
                );
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
        // Prueba de conexión
        MongoDatabase database = getDatabase();
        if (database != null) {
            System.out.println("Base de datos seleccionada: " + database.getName());
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
        closeConnection();
    }
}

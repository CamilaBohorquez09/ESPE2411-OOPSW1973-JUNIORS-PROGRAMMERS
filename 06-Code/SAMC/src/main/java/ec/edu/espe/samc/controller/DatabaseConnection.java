package ec.edu.espe.samc.controller;

import com.mongodb.client.MongoDatabase;

public interface DatabaseConnection {
    MongoDatabase getDatabase();
    void closeConnection();
}

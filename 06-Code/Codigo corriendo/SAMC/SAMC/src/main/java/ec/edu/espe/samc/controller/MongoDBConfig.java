package ec.edu.espe.samc.controller;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBConfig {
    private static final String URI = "mongodb+srv://rchapigo:1234@cluster0.0etpp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0/";

    public static MongoClientSettings getMongoClientSettings() {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        return MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(URI))
                .codecRegistry(codecRegistry)
                .build();
    }
}

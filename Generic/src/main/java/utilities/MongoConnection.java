package utilities;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnection {
    public static MongoDatabase mongoDatabase = null;
    public static MongoCollection<Document> collection = null;

    public static MongoDatabase connectMongoDB(String databaseName,String collectionName) {
        String host = "localhost";
        int port = 27017;
        MongoClient mongo = new MongoClient(host, port);
        mongoDatabase = mongo.getDatabase(databaseName);
        collection = mongoDatabase.getCollection(collectionName);
        return mongoDatabase;
    }
}
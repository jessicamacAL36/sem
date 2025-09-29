package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App {
    public static void main(String[] args) {

        // Use try-with-resources to ensure the connection is closed.
        try (MongoClient mongoClient = new MongoClient("localhost", 27000)) { // FIX: Initialize MongoClient here
            // Get a database - will create when we use it
            MongoDatabase database = mongoClient.getDatabase("mydb");
            // Get a collection from the database
            MongoCollection<Document> collection = database.getCollection("test");

            // Create and insert a document
            Document doc = new Document("name", "Kevin Sim")
                    .append("class", "DevOps")
                    .append("year", "2024")
                    .append("result", new Document("CW", 95).append("EX", 85));
            collection.insertOne(doc);

            // Check document in collection
            Document myDoc = collection.find().first();
            System.out.println(myDoc.toJson());
        } // The mongoClient.close() is called automatically here

        // The process finished exit code 0 is now guaranteed to happen after cleanup.
    }
}
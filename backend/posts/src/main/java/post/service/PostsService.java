package post.service;

import javax.enterprise.context.ApplicationScoped;

import com.mongodb.client.*;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import post.entity.Posts;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PostsService {
    public List<Document> getPosts(){

        MongoClient mongoClient = MongoClients.create("mongodb://postsdb:27017");
        MongoDatabase database = mongoClient.getDatabase("arep-posts");
        MongoCollection<Document> collection = database.getCollection("logs");

        List<Document> documents = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().limit(10).sort(Sorts.descending("date")).iterator()) {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        }

        mongoClient.close();
        return documents;
    }

}

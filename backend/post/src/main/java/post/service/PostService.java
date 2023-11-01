package post.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import post.entity.Post;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@ApplicationScoped
public class PostService {

    public void savePost(Post post) {

        MongoClient mongoClient = MongoClients.create("mongodb://postsdb:27017");
        MongoDatabase database = mongoClient.getDatabase("arep-posts");
        MongoCollection<Document> collection = database.getCollection("logs");

        Document document = new Document()
        .append("userId", post.getUserId())
        .append("text", post.getText())
        .append("date", post.getDate());

        collection.insertOne(document);
        mongoClient.close();
    }

}

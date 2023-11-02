package post.service;

import javax.enterprise.context.ApplicationScoped;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import post.entity.Post;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

@ApplicationScoped
public class PostService {

    public void savePost(Post post) {

        MongoClient mongoClient = MongoClients.create("mongodb://postsdb:27017");
        MongoDatabase database = mongoClient.getDatabase("arep-posts");
        MongoCollection<Document> collection = database.getCollection("posts");

        Document document = new Document()
        .append("userId", post.getUserId())
        .append("text", post.getText())
        .append("date", post.getDate());

        collection.insertOne(document);
        mongoClient.close();
    }

}

package post.service;

import javax.enterprise.context.ApplicationScoped;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import post.entity.Posts;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PostsService {

    public String getPosts(){

        MongoClient mongoClient = MongoClients.create("mongodb://postsdb:27017");
        MongoDatabase database = mongoClient.getDatabase("arep-posts");
        MongoCollection<Document> collection = database.getCollection("posts");

        List<Document> documents = new ArrayList<>();

        try (MongoCursor<Document> cursor = collection.find().limit(10).sort(Sorts.descending("date")).iterator()) {
            while (cursor.hasNext()) {
                documents.add(cursor.next());
            }
        }

        System.out.println("Documents: ");

        System.out.println(documents.toString());

        String results = convertToJson(documents);

        mongoClient.close();

        return results;
    }

    private String convertToJson(List<Document> documents) {
        JsonArray jsonResultArray = new JsonArray();

        for (Document document : documents) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("userId", document.get("userId", String.class));
            jsonObject.addProperty("text", document.get("text", String.class));
            jsonObject.addProperty("date", document.get("date", String.class));

            jsonResultArray.add(jsonObject);
        }

        String jsonString = jsonResultArray.toString();

        return jsonString;
    }

}

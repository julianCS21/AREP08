package org.example.service;

import javax.inject.Inject;
import org.example.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;


import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class UserService {



    @Inject
    MongoClient mongoClient;


    public User addUser(User newUser){
        Document document = new Document()
                .append("username", newUser.getUsername())
                .append("token", newUser.getToken());


        getCollection().insertOne(document);

        return newUser;
    }


    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                User sentUser = new User("","");
                sentUser.setUsername(document.getString("username"));
                sentUser.setUsername(document.getString("token"));
                users.add(sentUser);
            }
        } finally {
            cursor.close();
        }
        return users;
    }


    public MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("usersdb").getCollection("users");
    }






}

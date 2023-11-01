package post.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String userId;
    private String text;
    private String date;

    public Post(String userId, String text){
        this.text = text;
        this.userId = userId;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    public String toString(){
        return "{" +
            "\"userId\": " + "\"" + userId + "\"," + 
            "\"text\": " + "\"" + text + "\"," +
            "\"date\": " + "\"" + date + "\"" +
            "}";
    }

    public String getUserId(){
        return this.userId;
    }

    public String getText(){
        return this.text;
    }

    public String getDate(){
        return this.date;
    }
}
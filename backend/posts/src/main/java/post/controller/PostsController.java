package post.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import org.bson.Document;
import post.entity.Posts;
import post.service.PostsService;

import java.util.List;

@Path("/api")
public class PostsController {

    PostsService postsService = new PostsService();

    @GET
    public List<Document> getPosts() {

        List<Document> posts = postsService.getPosts();

        return posts;
    }

}

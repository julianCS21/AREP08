package post.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import post.entity.Post;
import post.service.PostService;

@Path("/api/v1/post")
public class PostController {

    PostService postService = new PostService();

    @POST
    public void addPost(String post) {

        Gson gson = new Gson();

        Post data = gson.fromJson(post, Post.class);
        data.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        postService.savePost(data);

    }
}

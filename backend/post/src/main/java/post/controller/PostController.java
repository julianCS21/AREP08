package post.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import post.entity.Post;
import post.service.PostService;

@Path("/api")
public class PostController {

    PostService postService = new PostService();

    @GET
    public String getPost() {
        return "posttttttts";
    }

    @POST
    public void addPost(String post) {

        Gson gson = new Gson();

        Post data = gson.fromJson(post, Post.class);
        System.out.println(data);
        postService.savePost(data);

    }
}

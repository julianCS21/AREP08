package post.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import post.service.PostsService;

@Path("/api/v1/posts")
public class PostsController {

    PostsService postsService = new PostsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPosts() {

        String posts = postsService.getPosts();

        return posts;
    }

}

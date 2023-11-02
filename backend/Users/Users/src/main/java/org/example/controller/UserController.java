package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.User;
import org.example.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/v1/users")
public class UserController {



    @Inject
    UserService userService;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() throws JsonProcessingException {
        return Response.ok("{\"data\": " + new ObjectMapper().writeValueAsString(userService.getAllUsers()) + "}").build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User newUser) throws JsonProcessingException {
        return Response.ok("{\"data\": " + new ObjectMapper().writeValueAsString(userService.addUser(newUser)) + "}").build();
    }


}


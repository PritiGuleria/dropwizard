package com.priti.routes;

import com.priti.AppConfiguration;
import com.priti.MongoConnection;
import com.priti.Users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by prguleri on 9/4/2017.
 */
@Path("/app")
public class Resources {

    private MongoConnection mongoConnection;

    public Resources(AppConfiguration appConfiguration) {
        mongoConnection = new MongoConnection(appConfiguration.getMongoConfig());

    }

    @POST
    @Path("/add/users")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addUser(Users users) {
        return mongoConnection.addNames(users);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUsers() {

        return mongoConnection.getUsers();
    }

    @POST
    @Path("/update/{user}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean updateUser(@PathParam("user") String userName,Users newUsers) {
        return mongoConnection.updateUser(userName,newUsers);

    }

    @DELETE
    @Path("/remove/{name}")
    public boolean removeUser(@PathParam("name") String name){
        return mongoConnection.deleteUser(name);
    }

}

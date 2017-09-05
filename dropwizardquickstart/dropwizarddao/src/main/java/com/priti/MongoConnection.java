package com.priti;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prguleri on 9/4/2017.
 */
public class MongoConnection {
    private MongoCollection<Document> mongoCollection;

    public MongoConnection(MongoConfig mongoConfig) {

        MongoClient mongoClient = new MongoClient(mongoConfig.getMongoUrl());
        MongoDatabase db = mongoClient.getDatabase(mongoConfig.getMongoDb());
        mongoCollection = db.getCollection("namesCol");
    }


    public boolean addNames(Users users) {
        Document doc = new Document("name", users.getName())
                .append("age", users.getAge())
                .append("gender", users.getGender());

        try {
            mongoCollection.insertOne(doc);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Users> getUsers() {

        List<Users> list = new ArrayList<Users>();
        FindIterable<Document> iterable = mongoCollection.find();

        for (Document doc : iterable) {
            Users user = new Users();
            user.setName(doc.getString("name"));
            user.setAge(doc.getInteger("age"));
            user.setGender(doc.getString("gender"));
            list.add(user);
        }

        return list;
    }

    public boolean updateUser(String userName,Users newUsers){
        BasicDBObject query = new BasicDBObject();
        query.put("name",userName);

        BasicDBObject newValue = new BasicDBObject();
        Document doc = new Document("name",newUsers.getName());
        newValue.put("$set",doc);

        UpdateResult result =mongoCollection.updateOne(query,newValue);
        return result.wasAcknowledged();
    }

    public boolean deleteUser(String name){
        BasicDBObject query = new BasicDBObject("name",name);

        try {
            mongoCollection.deleteOne(query);
            return  true;
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }

    }


}

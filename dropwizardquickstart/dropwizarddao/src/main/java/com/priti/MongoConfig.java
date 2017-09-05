package com.priti;

import io.dropwizard.Configuration;

/**
 * Created by prguleri on 9/4/2017.
 */
public class MongoConfig extends Configuration {

    private String mongoUrl;
    private String mongoDb;


    public String getMongoDb() {
        return mongoDb;
    }

    public String getMongoUrl() {
        return mongoUrl;
    }
}

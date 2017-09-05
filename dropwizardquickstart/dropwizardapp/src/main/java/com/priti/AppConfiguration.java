package com.priti;

import io.dropwizard.Configuration;

/**
 * Created by prguleri on 9/4/2017.
 */
public class AppConfiguration extends Configuration {

      private MongoConfig mongoConfig;

    public MongoConfig getMongoConfig() {
        return mongoConfig;
    }
}

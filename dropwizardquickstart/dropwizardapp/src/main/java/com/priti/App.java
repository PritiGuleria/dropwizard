package com.priti;

import com.priti.routes.Resources;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Created by prguleri on 9/4/2017.
 */
public class App extends Application<AppConfiguration> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
    public void run(AppConfiguration appConfig, Environment environment) throws Exception {

        Resources resources = new Resources(appConfig);
        environment.jersey().register(resources);

    }
}

package com.priti;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by prguleri on 9/5/2017.
 */
public class BusinessLayer {

    private static final Set<String> GOLD_USERS = new HashSet<String>();

    public static void addGoldUser(String name ){
        GOLD_USERS.add(name.toLowerCase());
    }

    public static boolean isMale(User user) {
        return user.getGender() != null && user.getGender().toLowerCase().startsWith("m");
    }

    public static boolean isGoldUser(String name){
        return GOLD_USERS.contains(name.toLowerCase());
    }

}

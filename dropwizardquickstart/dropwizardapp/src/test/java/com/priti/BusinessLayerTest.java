package com.priti;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by prguleri on 9/5/2017.
 */
public class BusinessLayerTest {

    private User user;


    @Before
    public void setupPerTest() {
        System.out.println("For Every Test");
        this.user = new User("sohi", 12, "Female");
    }

    @BeforeClass
    public static void setupPerClass(){
        System.out.println("One Time only");
        BusinessLayer.addGoldUser("Priti");
    }



    @Test
    public void isMale() throws Exception {
        user.setGender("Male");
        boolean isMale = BusinessLayer.isMale(user);
        assertTrue(isMale);
        assertFalse(BusinessLayer.isGoldUser(user.getName()));
    }

    @Test
    public void isFemale() throws Exception {
        user.setName("Priti");
        boolean isFemale = !BusinessLayer.isMale(user);
        assertTrue(isFemale);
        assertTrue(BusinessLayer.isGoldUser(user.getName()));
    }

}
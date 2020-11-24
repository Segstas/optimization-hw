package com.sbt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TestRunner {
    public static void main(String[] args) {
        User userObject = new User(
                "Norman",
                "norman@futurestud.io",
                26,
                true
        );
        Gson gson = new Gson();
        String userSerialization = gson.toJson(userObject);
        System.out.println(userSerialization);
        User userDeserialization = gson.fromJson(userSerialization, User.class);
        System.out.println(userDeserialization);




    }
}
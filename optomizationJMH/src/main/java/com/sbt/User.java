package com.sbt;

public class User{
    String name;
    String email;
    Integer age;
    boolean isAdmin;

    public User(String name, String email, Integer age, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
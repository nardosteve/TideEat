package com.stormapps.tideeat.Model;

public class User {

    private String Name;
    private String Password;

    public User(){

    }

    //Constructor
    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    //Getters and Setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

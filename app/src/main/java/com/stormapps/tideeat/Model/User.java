package com.stormapps.tideeat.Model;

public class User {

    private String Name;
    private String Password;
    private String Phone;

    public User(String s, String toString){

    }

    //Constructor
    public User(String name, String password, String phone) {
        Name = name;
        Password = password;
        Phone = phone;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}

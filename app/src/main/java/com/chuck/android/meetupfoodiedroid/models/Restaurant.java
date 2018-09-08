package com.chuck.android.meetupfoodiedroid.models;

public class Restaurant {

    private int id;
    private String Name;
    private String Address;

    public Restaurant(int id, String name, String address) {
        this.id = id;
        Name = name;
        Address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}

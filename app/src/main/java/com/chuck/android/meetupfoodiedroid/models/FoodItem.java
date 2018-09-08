package com.chuck.android.meetupfoodiedroid.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.UUID;

@Entity(tableName = "foodItems")

public class FoodItem {
    //Food item attributes
    @PrimaryKey
    @NonNull private String id;
    private String itemName;
    private int imgSrc;
    private double price;
    private double customPrice;

    public FoodItem( String itemName, Integer imgSrc, double price, double customPrice) {
        this.id = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.imgSrc = imgSrc;
        this.price = price;
        this.customPrice = customPrice;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCustomPrice() {
        return customPrice;
    }

    public void setCustomPrice(double customPrice) {
        this.customPrice = customPrice;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {this.id = id;}

    //Constructor



}

package com.chuck.android.meetupfoodiedroid.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.UUID;

@Entity(tableName = "foodItems")

public class FoodItem {
    //Food item attributes
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fid")
    private int id;
    private String itemName;
    private String addDescription;
    private int imgSrc;
    private double price;
    private double customPrice;

    public FoodItem( String itemName,String addDescription, Integer imgSrc, double price, double customPrice) {
        this.itemName = itemName;
        this.addDescription = addDescription;
        this.imgSrc = imgSrc;
        this.price = price;
        this.customPrice = customPrice;
    }
    @Ignore
    public FoodItem(){}


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

    public int getId() {
        return id;
    }

    public void setId(int id){this.id = id;}

    public String getAddDescription() {
        return addDescription;
    }

    public void setAddDescription(String addDescription) {
        this.addDescription = addDescription;
    }

    //Constructor



}

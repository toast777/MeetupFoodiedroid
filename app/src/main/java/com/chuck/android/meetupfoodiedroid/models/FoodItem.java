package com.chuck.android.meetupfoodiedroid.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "foodItems")

public class FoodItem {
    //Food item attributes
    @PrimaryKey
    private Integer id;
    private String itemName;
    private Integer imgSrc;
    private Float price;
    private Float customPrice;

    public FoodItem(Integer id, String itemName, Integer imgSrc, Float price, Float customPrice) {
        this.id = id;
        this.itemName = itemName;
        this.imgSrc = imgSrc;
        this.price = price;
        this.customPrice = customPrice;
    }

    public Integer getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(Integer imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCustomPrice() {
        return customPrice;
    }

    public void setCustomPrice(Float customPrice) {
        this.customPrice = customPrice;
    }
    //Constructor



}

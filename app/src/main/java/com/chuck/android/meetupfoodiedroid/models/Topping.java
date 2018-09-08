package com.chuck.android.meetupfoodiedroid.models;


public class Topping {
    private Integer id;
    private Integer restId;
    private String toppingName;
    private Integer imgSrc;
    private Float price;


    public Topping(Integer id, Integer restId, String toppingName, Float price) {
        this.id = id;
        this.restId = restId;
        this.toppingName = toppingName;
        this.imgSrc = 0;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRestId() {
        return restId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
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
}

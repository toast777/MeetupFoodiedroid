package com.chuck.android.meetupfoodiedroid.models;

import java.util.Date;

public class Order {

    private int id;
    private Date orderDate;
    private float total;

    public Order(int id, Date orderDate, float total) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}

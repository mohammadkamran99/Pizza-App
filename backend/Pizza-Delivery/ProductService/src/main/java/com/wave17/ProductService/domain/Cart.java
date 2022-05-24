package com.wave17.ProductService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document
public class Cart {

    private int pizzaId;
    private String pizzaName;
    private String size;
    private double price;
    private int userId;

    public Cart() {
    }

    public Cart(int pizzaId, String pizzaName, String size, double price, int userId) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.size = size;
        this.price = price;
        this.userId = userId;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "pizzaId=" + pizzaId +
                ", pizzaName='" + pizzaName + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }
}

package com.wave17.ProductService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Pizza {
    @Id
    private int pizzaId;
    private String pizzaName;
    private String size;
    private double price;

    public Pizza() {
    }

    public Pizza(int pizzaId, String pizzaName, List<Topping> toppings, String size, double price) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;

        this.size = size;
        this.price = price;
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

    @Override
    public String toString() {
        return "Pizza{" +
                "pizzaName='" + pizzaName + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}

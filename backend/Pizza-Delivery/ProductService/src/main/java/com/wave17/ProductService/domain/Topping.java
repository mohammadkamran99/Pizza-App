package com.wave17.ProductService.domain;

public class Topping {
    private String toppingName;
    private String size;
    private double price;

    public Topping() {
    }

    public Topping(String toppingName, String size, double price) {
        this.toppingName = toppingName;
        this.size = size;
        this.price = price;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
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
        return "Topping{" +
                "toppingName='" + toppingName + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}

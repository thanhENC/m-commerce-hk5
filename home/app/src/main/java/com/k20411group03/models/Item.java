package com.k20411group03.models;

import android.widget.LinearLayout;

public class Item {
    int productID;
    int cateID;
    String description;
    int inventory;
    int thumbID;
    String productName;
    int price;
    int originalPrice;
    double discount;
    double rating;
    int numOfReviews;
    String[] color;
    String[] size;

    public Item(int productID, int cateID, String description, int inventory, int thumbID, String productName, int price, int originalPrice, double discount, double rating, int numOfReviews, String[] color, String[] size) {
        this.productID = productID;
        this.cateID = cateID;
        this.description = description;
        this.inventory = inventory;
        this.thumbID = thumbID;
        this.productName = productName;
        this.price = price;
        this.originalPrice = originalPrice;
        this.discount = discount;
        this.rating = rating;
        this.numOfReviews = numOfReviews;
        this.color = color;
        this.size = size;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getThumbID() {
        return thumbID;
    }

    public void setThumbID(int thumbID) {
        this.thumbID = thumbID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(int numOfReviews) {
        this.numOfReviews = numOfReviews;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public String[] getSize() {
        return size;
    }

    public void setSize(String[] size) {
        this.size = size;
    }
}



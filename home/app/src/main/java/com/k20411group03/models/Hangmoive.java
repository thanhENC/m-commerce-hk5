package com.k20411group03.models;

public class Hangmoive {
    String newproduct_Name;
    int newproduct_Price;
    int newproduct_Image;

    public Hangmoive(String newproduct_Name, int newproduct_Price, int newproduct_Image) {

        this.newproduct_Name = newproduct_Name;
        this.newproduct_Price = newproduct_Price;
        this.newproduct_Image = newproduct_Image;
    }

    public String getNewproduct_Name() {
        return newproduct_Name;
    }

    public void setNewproduct_Name(String newproduct_Name) {
        this.newproduct_Name = newproduct_Name;
    }

    public int getNewproduct_Price() {
        return newproduct_Price;
    }

    public void setNewproduct_Price(int newproduct_Price) {
        this.newproduct_Price = newproduct_Price;
    }

    public int getNewproduct_Image() {
        return newproduct_Image;
    }

    public void setNewproduct_Image(int newproduct_Image) {
        this.newproduct_Image = newproduct_Image;
    }
}

package com.k20411group03.models;

public class Bosuutapmoi {
    String newcollection_Name;
    int newcollection_Price;
    int newcollection_Image;

    public Bosuutapmoi(String newcollection_Name, int newcollection_Price, int newcollection_Image) {
        this.newcollection_Name = newcollection_Name;
        this.newcollection_Price = newcollection_Price;
        this.newcollection_Image = newcollection_Image;
    }

    public String getNewcollection_Name() {
        return newcollection_Name;
    }

    public void setNewcollection_Name(String newcollection_Name) {
        this.newcollection_Name = newcollection_Name;
    }

    public int getNewcollection_Price() {
        return newcollection_Price;
    }

    public void setNewcollection_Price(int newcollection_Price) {
        this.newcollection_Price = newcollection_Price;
    }

    public int getNewcollection_Image() {
        return newcollection_Image;
    }

    public void setNewcollection_Image(int newcollection_Image) {
        this.newcollection_Image = newcollection_Image;
    }



}

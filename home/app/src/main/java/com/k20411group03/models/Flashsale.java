package com.k20411group03.models;

public class Flashsale {
    int ProductID;
    String productName;
    byte[] Thumbnail;
    double ProductPrice;
    double SalePrice;
    int Inventory;

    public Flashsale(int productID, String productName, byte[] thumbnail, double productPrice, double salePrice, int inventory) {
        ProductID = productID;
        this.productName = productName;
        Thumbnail = thumbnail;
        ProductPrice = productPrice;
        SalePrice = salePrice;
        Inventory = inventory;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public byte[] getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        Thumbnail = thumbnail;
    }

    public double getProductPrice() {
        return ProductPrice;
    }

    public String formatProductPrice(double price) {
        String str = (int) price + "";
        int count = 0;
        for(int i = str.length() - 1; i > 0; i--){
            count++;
            if(count == 3){
                str = str.substring(0, i) + "." + str.substring(i);
                count = 0;
            }
        }
        return str;
    }

    public void setProductPrice(double productPrice) {
        ProductPrice = productPrice;
    }

    public double getSalePrice() {
        return SalePrice;
    }

    public void setSalePrice(double salePrice) {
        SalePrice = salePrice;
    }

    public int getInventory() {
        return Inventory;
    }

    public void setInventory(int inventory) {
        Inventory = inventory;
    }
}


package com.k20411group03.models;

public class Flashsale {
    String product_Name;
    int product_PriceSale;
    int product_Price;
    int product_Image;
    int flashsale_Quantity;
    String flashsale_Percent;

    public Flashsale(String product_Name, int product_Price, int product_PriceSale, int product_Image, int flashsale_Quantity, String flashsale_Percent) {
        this.product_Image = product_Image;
        this.product_Name = product_Name;
        this.product_Price = product_Price;
        this.product_PriceSale = product_PriceSale;
        this.flashsale_Quantity = flashsale_Quantity;
        this.flashsale_Percent = flashsale_Percent;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public int getProduct_PriceSale() {
        return product_PriceSale;
    }

    public void setProduct_PriceSale(int product_PriceSale) {
        this.product_PriceSale = product_PriceSale;
    }

    public int getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(int product_Price) {
        this.product_Price = product_Price;
    }

    public int getProduct_Image() {
        return product_Image;
    }

    public void setProduct_Image(int product_Image) {
        this.product_Image = product_Image;
    }

    public int getFlashsale_Quantity() {
        return flashsale_Quantity;
    }

    public void setFlashsale_Quantity(int flashsale_Quantity) {
        this.flashsale_Quantity = flashsale_Quantity;
    }

    public String getFlashsale_Percent() {
        return flashsale_Percent;
    }

    public void setFlashsale_Percent(String flashsale_Percent) {
        this.flashsale_Percent = flashsale_Percent;
    }
}


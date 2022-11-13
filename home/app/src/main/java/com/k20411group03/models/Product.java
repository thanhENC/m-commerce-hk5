package com.k20411group03.models;

public class Product {
    String product_Name;
    double product_Price;
    int product_Image;
    String product_Size;
    String product_Color;
    int product_Quantity;
    boolean product_Checked;

    public Product(String product_Name, double product_Price, int product_Image, String product_Size, String product_Color, int product_Quantity, boolean product_Checked) {
        this.product_Name = product_Name;
        this.product_Price = product_Price;
        this.product_Image = product_Image;
        this.product_Size = product_Size;
        this.product_Color = product_Color;
        this.product_Quantity = product_Quantity;
        this.product_Checked = product_Checked;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public double getProduct_Price() {
        return product_Price;
    }

    public void setProduct_Price(double product_Price) {
        this.product_Price = product_Price;
    }

    public int getProduct_Image() {
        return product_Image;
    }

    public void setProduct_Image(int product_Image) {
        this.product_Image = product_Image;
    }

    public String getProduct_Size() {
        return product_Size;
    }

    public void setProduct_Size(String product_Size) {
        this.product_Size = product_Size;
    }

    public String getProduct_Color() {
        return product_Color;
    }

    public void setProduct_Color(String product_Color) {
        this.product_Color = product_Color;
    }

    public int getProduct_Quantity() {
        return product_Quantity;
    }

    public void setProduct_Quantity(int product_Quantity) {
        this.product_Quantity = product_Quantity;
    }

    public boolean isProduct_Checked() {
        return product_Checked;
    }

    public void setProduct_Checked(boolean product_Checked) {
        this.product_Checked = product_Checked;
    }
}



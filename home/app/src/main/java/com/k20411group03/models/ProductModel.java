package com.k20411group03.models;

public class ProductModel {
    int productID;
    String productName;
    String categoryID;
    byte[] productImage;
    Double productPrice;
    Double productSalePrice;
    String productDescription;
    int productInventory;

    public ProductModel(int productID, String productName, String categoryID, byte[] productImage, Double productPrice, Double productSalePrice, String productDescription, int productInventory) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productSalePrice = productSalePrice;
        this.productDescription = productDescription;
        this.productInventory = productInventory;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(Double productSalePrice) {
        this.productSalePrice = productSalePrice;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
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
}

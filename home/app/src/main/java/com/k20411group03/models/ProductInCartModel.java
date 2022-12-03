package com.k20411group03.models;

public class ProductInCartModel extends ProductModel {
    int productQuantity;

    public ProductInCartModel(int productID, String productName, String categoryID, byte[] productImage, Double productPrice, Double productSalePrice, String productDescription, int productInventory, int productQuantity) {
        super(productID, productName, categoryID, productImage, productPrice, productSalePrice, productDescription, productInventory);
        this.productQuantity = productQuantity;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}

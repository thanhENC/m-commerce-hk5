package com.k20411group03.models;

public class ProductInCartModel extends ProductModel {
    //ProductIntentory ở đây là số lượng sản phẩm trong giỏ hàng
    //ProductInventory ở ProductModel là số lượng sản phẩm trong kho

    //3 thuộc tính mở rộng cho ProductInCartModel
    String productSize, productColor;
    Boolean productIsChecked;

    //Constructor
    public ProductInCartModel(int productID, String productName, String categoryID, byte[] productImage, Double productPrice, Double productSalePrice, String productDescription, int productInventory, String productSize, String productColor, Boolean productIsChecked) {
        super(productID, productName, categoryID, productImage, productPrice, productSalePrice, productDescription, productInventory);
        this.productSize = productSize;
        this.productColor = productColor;
        this.productIsChecked = productIsChecked;
    }

    //Getter và Setter
    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public Boolean getProductIsChecked() {
        return productIsChecked;
    }

    public void setProductIsChecked(Boolean productIsChecked) {
        this.productIsChecked = productIsChecked;
    }
}

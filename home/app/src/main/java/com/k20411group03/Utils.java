package com.k20411group03;
import android.database.sqlite.SQLiteDatabase;

public class Utils {
    //===============CƠ SỞ DỮ LIỆU THE WEEKDAYS===============
    public static final String DB_NAME = "theweekdays.db";
    public static final String DB_PATH_SUFFIX = "/databases/";

    //===============CÁC BẢNG TRONG CƠ SỞ DỮ LIỆU===============
    //BẢNG PRODUCT
    public static final String TBL_NAME = "PRODUCT";
    public static final String COL_ID = "ProductID";
    public static final String COL_NAME = "ProductName";
    public static final String COL_CATEGORY = "CategoryID";
    public static final String COL_IMAGE = "Thumbnail";
    public static final String COL_PRICE = "ProductPrice";
    public static final String COL_SALEPRICE = "SalePrice";
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_INVENTORY = "Inventory";

    //BẢNG CART
    public static class Cart {
        public static final String TBL_NAME = "CART";
        public static final String COL_ID = "LineID";
        public static final String COL_CUSTOMEID = "CustomerID";
        public static final String COL_PRODUCTID = "ProductID";
        public static final String COL_QUANTITY = "Quantity";
    }

    //BẢNG CUSTOMER
    public static class Customer {
        public static final String TBL_NAME = "CUSTOMER";
        public static final String COL_ID = "CustomerID";
        public static final String COL_USERNAME = "Username";
        public static final String COL_FIRSTNAME = "FirstName";
        public static final String COL_LASTNAME = "LastName";
        public static final String COL_EMAIL = "Email";
        public static final String COL_PHONE = "Phone";
        public static final String COL_PASSWORD = "Password";
        public static final String COL_MEMBERSHIPSCORE = "MembershipScore";
    }

    //BẢNG ADDRESS

    //BẢNG ORDER
    public static class Order {
        public static final String TBL_NAME = "ORDER";
        public static final String COL_ID = "OrderID";
        public static final String COL_CUSTOMERID = "CustomerID";
        public static final String COL_ORDERDATE = "Date";
        public static final String COL_PAYMENTMETHOD = "PaymentMethod";
        public static final String COL_PAYMENTID = "PaymentID";
        public static final String COL_COUPONCODE = "CouponCode";
        public static final String COL_TOTAL = "Total";
        public static final String COL_STATUS = "Status";
        public static final String COL_NOTE = "Note";
    }

    //BẢNG ORDERLINE
    public static class OrderLine {
        public static final String TBL_NAME = "ORDERLINE";
        public static final String COL_ID = "LineID";
        public static final String COL_ORDERID = "OrderID";
        public static final String COL_PRODUCTID = "ProductID";
        public static final String COL_SALEPRICE = "SalePrice";
        public static final String COL_QUANTITY = "Quantity";
    }

}


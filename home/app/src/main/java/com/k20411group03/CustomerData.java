package com.k20411group03;

import com.k20411group03.models.ProductModel;

import java.util.ArrayList;

public class CustomerData {
    //Tạm thời set cố định, sau này sẽ lấy từ database sau khi đăng nhập thành công
    public static class info{
        public static int USER_ID = 5;
        public static String USER_NAME = "andv20411";
        public static String FIRST_NAME = "Đinh";
        public static String LAST_NAME = "Văn An";
        public static String EMAIL = "andv20411@st.uel.edu.vn";
        public static String PHONE = "";
        public static int MEMBERSHIP_SCORE = 325;
        public static String MEMBERSHIP_LEVEL = "Thành viên Vàng";
    }

    //Update info người dùng
    public static void updateInfo(int id, String username, String firstname, String lastname, String email, String phone, int score){
        info.USER_ID = id;
        info.USER_NAME = username;
        info.FIRST_NAME = firstname;
        info.LAST_NAME = lastname;
        info.EMAIL = email;
        info.PHONE = phone;
        info.MEMBERSHIP_SCORE = score;
        if(score < 100){
            info.MEMBERSHIP_LEVEL = "Thành viên Đồng";
        }else if(score < 200){
            info.MEMBERSHIP_LEVEL = "Thành viên Bạc";
        }else if(score < 300){
            info.MEMBERSHIP_LEVEL = "Thành viên Vàng";
        }else{
            info.MEMBERSHIP_LEVEL = "Thành viên Kim Cương";
        }
    }

    public static class address{
        public static String CITY = "TP. Hồ Chí Minh";
        public static String DISTRICT = "TP. Thủ Đức";
        public static String WARD = "Phường Linh Xuân";
        public static String STREET = "Đường 8";
        public static String HOUSE_NUMBER = "Số 95";
        public static String ADDRESS = HOUSE_NUMBER + " " + STREET + ", " + WARD + ", " + DISTRICT + ", " + CITY;
    }

    //Update địa chỉ người dùng
    public static void updateAddress(String city, String district, String ward, String street, String houseNumber){
        address.CITY = city;
        address.DISTRICT = district;
        address.WARD = ward;
        address.STREET = street;
        address.HOUSE_NUMBER = houseNumber;
        address.ADDRESS = houseNumber + " " + street + ", " + ward + ", " + district + ", " + city;
    }

    public static ProductModel[] cart = new ProductModel[0];

    public static ArrayList<ProductModel> wishlist = new ArrayList<>();
    //select * from PRODUCT where ProductID in (select ProductID from WISHLIST WHERE CustomerID = 5)

    //insert product to cart
    public static void insertToCart(ProductModel product){
        ProductModel[] temp = new ProductModel[cart.length + 1];
        for(int i = 0; i < cart.length; i++){
            temp[i] = cart[i];
        }
        temp[cart.length] = product;
        cart = temp;
    }

    //remove product from cart
    public static void removeFromCart(ProductModel product){
        ProductModel[] temp = new ProductModel[cart.length - 1];
        int j = 0;
        for(int i = 0; i < cart.length; i++){
            if(cart[i].getProductID() != product.getProductID()){
                temp[j] = cart[i];
                j++;
            }
        }
        cart = temp;
    }

    //insert product to wishlist
    public static void insertToWishlist(ProductModel product){
        wishlist.add(product);
    }

    //remove product from wishlist
    public static void removeFromWishlist(ProductModel product){
        wishlist.remove(product);
    }
}

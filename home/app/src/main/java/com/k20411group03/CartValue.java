package com.k20411group03;

public class CartValue {
    public static int SUM_VALUE = 0;
    public static int VOUCHER_VALUE = 0;
    public static int SHIPPING_VALUE = 0;
    public static int TOTAL_PRICE = 0;
    public static String PAYMENT_METHOD = "";
    public static int PAYMENT_IMAGE = 0;

    public static void setSumValue(int sumValue) {
        SUM_VALUE = sumValue;
    }

    public static void setVoucherValue(int voucherValue) {
        VOUCHER_VALUE = voucherValue;
    }

    public static void setShippingValue(int shippingValue) {
        SHIPPING_VALUE = shippingValue;
    }

    public static void setTotalPrice(int totalPrice) {
        TOTAL_PRICE = totalPrice;
    }

    public static void setPaymentMethod(String paymentMethod) {
        PAYMENT_METHOD = paymentMethod;
    }

    public static void setPaymentImage(int paymentImage) {
        PAYMENT_IMAGE = paymentImage;
    }

    public static int getSumValue() {
        return SUM_VALUE;
    }

    public static int getVoucherValue() {
        return VOUCHER_VALUE;
    }

    public static int getShippingValue() {
        return SHIPPING_VALUE;
    }

    public static int getTotalPrice() {
        return TOTAL_PRICE;
    }

    public static String getPaymentMethod() {
        return PAYMENT_METHOD;
    }

    public static int getPaymentImage() {
        return PAYMENT_IMAGE;
    }

    public static void reset() {
        SUM_VALUE = 0;
        VOUCHER_VALUE = 0;
        SHIPPING_VALUE = 0;
        TOTAL_PRICE = 0;
        PAYMENT_METHOD = "";
        PAYMENT_IMAGE = 0;
    }
}

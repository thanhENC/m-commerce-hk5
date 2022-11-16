package com.k20411group03.models;

public class Payment {
    boolean paymentRadio;
    int paymentImage;
    String paymentName;
    String paymentNote;

    public Payment (boolean paymentRadio, int paymentImage, String paymentName, String paymentNote) {
        this.paymentRadio = paymentRadio;
        this.paymentImage = paymentImage;
        this.paymentName = paymentName;
        this.paymentNote = paymentNote;
    }

    public int getPaymentImage() {
        return paymentImage;
    }

    public void setPaymentImage(int paymentImage) {
        this.paymentImage = paymentImage;
    }

    public boolean getpaymentRadio() {
        return paymentRadio;
    }

    public void setProduct_Price(boolean paymentRadio) {
        this.paymentRadio = paymentRadio;
    }

    public  String getPaymentName() {return paymentName; }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentNote() {
        return paymentNote;
    }

    public void setPaymentNote(String paymentNote) {
        this.paymentNote = paymentNote;
    }
}



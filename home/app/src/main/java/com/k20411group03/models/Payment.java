package com.k20411group03.models;

public class Payment {
    int paymentId;
    boolean paymentRadio;
    int paymentImage;
    String paymentName;
    String paymentNote;

    public Payment (int paymentId , String paymentName, String paymentNote, int paymentImage, boolean paymentRadio) {
        this.paymentId = paymentId;
        this.paymentName = paymentName;
        this.paymentNote = paymentNote;
        this.paymentImage = paymentImage;
        this.paymentRadio = paymentRadio;
    }

    public int getpaymentId() {
        return paymentId;
    }

    public void setpaymentId(int paymentId) {
        this.paymentId = paymentId;
    }


    public int getPaymentImage() {
        return paymentImage;
    }

    public void setPaymentImage(int paymentImage) {
        this.paymentImage = paymentImage;
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

    public boolean getpaymentRadio() { return paymentRadio;
    }

    public void setPaymentRadio(boolean paymentRadio) {
        this.paymentRadio = paymentRadio;
    }

}



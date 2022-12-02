package com.k20411group03.models;

public class Voucher {
    String titleOfVoucher, hsdVoucher, maxValue;

    public Voucher(String titleOfVoucher, String hsdVoucher, String maxValue) {
        this.titleOfVoucher = titleOfVoucher;
        this.hsdVoucher = hsdVoucher;
        this.maxValue = maxValue;
    }

    public String getTitleOfVoucher() {
        return titleOfVoucher;
    }

    public void setTitleOfVoucher(String titleOfVoucher) {
        this.titleOfVoucher = titleOfVoucher;
    }

    public String getHsdVoucher() {
        return hsdVoucher;
    }

    public void setHsdVoucher(String hsdVoucher) {
        this.hsdVoucher = hsdVoucher;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }
}

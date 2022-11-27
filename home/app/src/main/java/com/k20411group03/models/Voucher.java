package com.k20411group03.models;

public class Voucher {
    String vouchertitle;
    String vouchersubtitle;
    String HSDvoucher;

    public String getVouchertitle() {
        return vouchertitle;
    }

    public void setVouchertitle(String vouchertitle) {
        this.vouchertitle = vouchertitle;
    }

    public String getVouchersubtitle() {
        return vouchersubtitle;
    }

    public void setVouchersubtitle(String vouchersubtitle) {
        this.vouchersubtitle = vouchersubtitle;
    }

    public String getHSDvoucher() {
        return HSDvoucher;
    }

    public void setHSDvoucher(String HSDvoucher) {
        this.HSDvoucher = HSDvoucher;
    }



    public Voucher(String vouchertitle, String DonToiThieu, String HSDvoucher) {
        this.vouchertitle = vouchertitle;
        this.vouchersubtitle = DonToiThieu;
        this.HSDvoucher = HSDvoucher;
    }

}

package com.k20411group03.models;

public class Notification {
    int thongBao_Image;
    String thongBao_Title;
    String thongBao_Content;

    public Notification(int thongBao_Image, String thongBao_Title, String thongBao_Content) {
        this.thongBao_Image = thongBao_Image;
        this.thongBao_Title = thongBao_Title;
        this.thongBao_Content = thongBao_Content;
    }

    public int getThongBao_Image() {
        return thongBao_Image;
    }

    public void setThongBao_Image(int thongBao_Image) {
        this.thongBao_Image = thongBao_Image;
    }

    public String getThongBao_Title() {
        return thongBao_Title;
    }

    public void setThongBao_Title(String thongBao_Title) {
        this.thongBao_Title = thongBao_Title;
    }

    public String getThongBao_Content() {
        return thongBao_Content;
    }

    public void setThongBao_Content(String thongBao_Content) {
        this.thongBao_Content = thongBao_Content;
    }
}

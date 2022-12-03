package com.k20411group03.models;

public class category {
    String cateID;
    int cateThumbID;
    String thumbName;

    public category(String cateID, int cateThumbID, String thumbName) {
        this.cateID = cateID;
        this.cateThumbID = cateThumbID;
        this.thumbName = thumbName;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public int getCateThumbID() {
        return cateThumbID;
    }

    public void setCateThumbID(int cateThumbID) {
        this.cateThumbID = cateThumbID;
    }

    public String getThumbName() {
        return thumbName;
    }

    public void setThumbName(String thumbName) {
        this.thumbName = thumbName;
    }
}

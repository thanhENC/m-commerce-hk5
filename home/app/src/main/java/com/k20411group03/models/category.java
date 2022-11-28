package com.k20411group03.models;

public class category {
    int cateID;
    int cateThumbID;
    String thumbName;

    public category(int cateID, int cateThumbID, String thumbName) {
        this.cateID = cateID;
        this.cateThumbID = cateThumbID;
        this.thumbName = thumbName;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
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

package com.k20411group03.models;

public class Address_province {
    String province_id;
    String province_name;
    String province_type;

    public Address_province(String province_id, String province_name, String province_type) {
        this.province_id = province_id;
        this.province_name = province_name;
        this.province_type = province_type;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getProvince_type() {
        return province_type;
    }

    public void setProvince_type(String province_type) {
        this.province_type = province_type;
    }
}

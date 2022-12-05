package com.k20411group03;

public class Utils {
    public static final String DB_NAME = "theweekdays.db";
    public static final String DB_PATH_SUFFIX = "/databases/";

    public static final String TBL_NAME = "PRODUCT";

    public static final String COL_ID = "ProductID";
    public static final String COL_NAME = "ProductName";
    public static final String COL_CATEGORY = "CategoryID";
    public static final String COL_IMAGE = "Thumbnail";
    public static final String COL_PRICE = "ProductPrice";
    public static final String COL_SALEPRICE = "SalePrice";
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_INVENTORY = "Inventory";

    //--------dia chi viet nam

    public static final String DB_LC_NAME = "diachivietnam.db";

    public static final String TBL_LC_PROVINCE = "province";
    public static final String COL_LC_PROVINCE_ID = "id";
    public static final String COL_LC_PROVINCE_NAME = "name";
    public static final String COL_LC_PROVINCE_TYPE = "type";

    public static final String TBL_LC_DISTRICT = "district";
    public static final String COL_LC_DISTRICT_ID = "id";
    public static final String COL_LC_DISTRICT_NAME = "name";
    public static final String COL_LC_DISTRICT_TYPE = "type";
    public static final String COL_LC_DISTRICT_PROVINCE_ID = "province_id";

    public static final String TBL_LC_WARD = "ward";
    public static final String COL_LC_WARD_ID = "id";
    public static final String COL_LC_WARD_NAME = "name";
    public static final String COL_LC_WARD_TYPE = "type";
    public static final String COL_LC_WARD_DISTRICT_ID = "district_id";
}


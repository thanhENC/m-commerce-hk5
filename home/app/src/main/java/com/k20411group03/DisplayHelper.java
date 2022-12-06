package com.k20411group03;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DisplayHelper {
    public static String formatPrice(double price){
        String str = (int) price + "";
        int count = 0;
        for(int i = str.length() - 1; i > 0; i--){
            count++;
            if(count == 3){
                str = str.substring(0, i) + "." + str.substring(i);
                count = 0;
            }
        }
        return str;
    }
    public static Bitmap convertByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    //convert Unix epoch time to normal time
    public static String convertUnixTimeToNormalTime(int unixTime){
        Date date = new Date(unixTime * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+7"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public static String shortenString(String str, int length){
        if(str.length() > length){
            return str.substring(0, length) + "...";
        }
        return str;
    }

    public static int getValue(String sum){
        //Convert 250.000 -> 250000
        try{
            String value = sum.replace(".", "");
            return Integer.parseInt(value);
        }catch (Exception e){
            return 0;
        }
    }
}

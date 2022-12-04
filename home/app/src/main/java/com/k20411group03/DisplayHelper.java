package com.k20411group03;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
}

package com.k20411group03;

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
}

package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k20411group03.home.R;
import com.k20411group03.models.ProductModel;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    Activity thisActivity;
    int layout;
    List<ProductModel> list;

    public ItemAdapter(Activity thisActivity, int layout, List<ProductModel> list) {
        this.thisActivity = thisActivity;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        ProductAdapter.ViewHolder viewHolder;

        if(view == null){
            //link views
            holder = new ItemAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) thisActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.imv_Thumb = view.findViewById(R.id.imv_Thumb);
            holder.txt_ItemName = view.findViewById(R.id.txt_ItemName);
            holder.txt_price = view.findViewById(R.id.txt_price);
            holder.txt_discount = view.findViewById(R.id.txt_discount);
            holder.txt_originalPrice = view.findViewById(R.id.txt_originalPrice);
            holder.txt_rating = view.findViewById(R.id.txt_rating);
            holder.txt_numOfReview = view.findViewById(R.id.txt_numOfReview);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }

        //binding data
        ProductModel item = list.get(i);
        holder.imv_Thumb.setImageBitmap(convertByteArrayToBitmap(item.getProductImage()));
        holder.txt_ItemName.setText(shortName(String.valueOf(item.getProductName())));
        holder.txt_price.setText(item.formatProductPrice(item.getProductSalePrice()));
        holder.txt_originalPrice.setText(item.formatProductPrice(item.getProductPrice()));

        return view;
    }
    private String shortName(String productName) {
        if(productName.length() >36){
            productName = productName.substring(0,36);
            productName = productName + "...";
        }
        return productName;
    }
    private Bitmap convertByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    class ViewHolder{
        ImageView imv_Thumb;
        TextView txt_ItemName, txt_price, txt_discount, txt_originalPrice, txt_rating, txt_numOfReview;
    }
}

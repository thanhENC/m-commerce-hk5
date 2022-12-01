package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.k20411group03.home.R;
import com.k20411group03.models.Item;
import com.k20411group03.models.Product;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Item> items;

    public ItemAdapter(Activity activity, int item_layout, List<Item> items) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
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
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

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
        Item item = items.get(i);
        holder.imv_Thumb.setImageResource(item.getThumbID());
        holder.txt_ItemName.setText(item.getProductName());
        holder.txt_price.setText(String.valueOf(item.getPrice()));
        holder.txt_discount.setText("(-" + String.valueOf(item.getDiscount())+"%)");
        holder.txt_originalPrice.setText(String.valueOf(item.getOriginalPrice()));
        holder.txt_rating.setText("(" + String.valueOf(item.getRating()) + ")");
        holder.txt_numOfReview.setText("(" +String.valueOf(item.getNumOfReviews())+")");

        return view;
    }
    class ViewHolder{
        ImageView imv_Thumb;
        TextView txt_ItemName, txt_price, txt_discount, txt_originalPrice, txt_rating, txt_numOfReview;
    }
}

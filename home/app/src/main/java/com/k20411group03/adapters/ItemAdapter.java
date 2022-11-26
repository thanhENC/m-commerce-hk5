package com.k20411group03.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.k20411group03.home.R;
import com.k20411group03.models.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder>{

    private List<Item> itemList;
    private Context context;

    public ItemAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Item> items){
        this.itemList = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = itemList.get(position);
        if(itemList == null){
            return;
        }

        holder.imv_Thumb.setImageResource(item.getThumbID());
        holder.txt_ItemName.setText(item.getProductName());
        holder.txt_price.setText(String.valueOf(item.getPrice()));
        holder.txt_discount.setText(String.valueOf(item.getDiscount()));
        holder.txt_originalPrice.setText(String.valueOf(item.getOriginalPrice()));
        holder.txt_rating.setText(String.valueOf(item.getRating()));
        holder.txt_numOfReview.setText(String.valueOf(item.getNumOfReviews()));
    }

    @Override
    public int getItemCount() {
        if(itemList != null){
            return itemList.size();
        }else {return 0;}
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imv_Thumb;
        TextView txt_ItemName;
        TextView txt_originalPrice;
        TextView txt_price;
        TextView txt_discount;
        TextView txt_rating;
        TextView txt_numOfReview;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imv_Thumb = itemView.findViewById(R.id.imv_Thumb);
            txt_ItemName = itemView.findViewById(R.id.txt_ItemName);
            txt_originalPrice = itemView.findViewById(R.id.txt_originalPrice);
            txt_price = itemView.findViewById(R.id.txt_price);
            txt_discount = itemView.findViewById(R.id.txt_discount);
            txt_rating = itemView.findViewById(R.id.txt_rating);
            txt_numOfReview = itemView.findViewById(R.id.txt_numOfReview);

        }
    }
}

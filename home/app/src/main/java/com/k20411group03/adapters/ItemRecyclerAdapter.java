package com.k20411group03.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.k20411group03.home.ProductDetails;
import com.k20411group03.home.R;
import com.k20411group03.models.Item;
import com.k20411group03.models.ProductModel;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemHolder>{

    private List<ProductModel> itemList;
    private Context context;

    public ItemRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ProductModel> items){
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
        ProductModel item = itemList.get(position);
        if(itemList == null){
            return;
        }

        holder.imv_Thumb.setImageBitmap(convertByteArrayToBitmap(item.getProductImage()));
        holder.txt_ItemName.setText(item.getProductName());
        holder.txt_price.setText(String.valueOf(item.getProductSalePrice()));
        holder.txt_originalPrice.setText(String.valueOf(item.getProductPrice()));
        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(item);
            }
        });
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
        LinearLayout layout_item;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imv_Thumb = itemView.findViewById(R.id.imv_Thumb);
            txt_ItemName = itemView.findViewById(R.id.txt_ItemName);
            txt_originalPrice = itemView.findViewById(R.id.txt_originalPrice);
            txt_price = itemView.findViewById(R.id.txt_price);
            txt_discount = itemView.findViewById(R.id.txt_discount) ;
            layout_item = itemView.findViewById(R.id.layout_item);

        }
    }

    //Function chuyển sang trang sản phẩm chi tiết khi nhấn vào sản phẩm trên recycler view
    private void onClickGoToDetail(ProductModel item) {
        Intent intent = new Intent(context, ProductDetails.class);
        intent.putExtra("ProductID", item.getProductID());
        context.startActivity(intent);
    }
    private Bitmap convertByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}

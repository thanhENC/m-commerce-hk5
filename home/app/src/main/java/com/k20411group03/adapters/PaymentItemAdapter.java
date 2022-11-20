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
import com.k20411group03.models.Product;

import java.util.List;

public class PaymentItemAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Product> products;

    public PaymentItemAdapter(Activity activity, int item_layout, List<Product> products) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PaymentItemAdapter.ViewHolder viewHolder;

        if(view == null){
            //link views
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            viewHolder.txtProductName = view.findViewById(R.id.txt_ProductName);
            viewHolder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);
            viewHolder.txtProductSize = view.findViewById(R.id.txt_ProductSize);
            viewHolder.txtProductColor = view.findViewById(R.id.txt_ProductColor);
            viewHolder.txtProductQuantity = view.findViewById(R.id.txt_ProductQuantity);
            viewHolder.imvProductImage = view.findViewById(R.id.imv_ProductImage);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        //binding data
        Product product = products.get(i);
        viewHolder.imvProductImage.setImageResource(product.getProduct_Image());
        viewHolder.txtProductName.setText(product.getProduct_Name());
        viewHolder.txtProductSize.setText(product.getProduct_Size());
        viewHolder.txtProductColor.setText(product.getProduct_Color());
        viewHolder.txtProductPrice.setText(String.valueOf(product.getProduct_Price()) + " Đ");
        viewHolder.txtProductQuantity.setText(String.valueOf(product.getProduct_Quantity()));

        return view;
    }

    class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice, txtProductSize, txtProductColor, txtProductQuantity;
    }
}

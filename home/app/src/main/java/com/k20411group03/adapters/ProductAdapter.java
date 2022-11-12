package com.k20411group03.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.k20411group03.home.R;
import com.k20411group03.models.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Product> products;

    public ProductAdapter(Activity activity, int item_layout, List<Product> products) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            viewHolder = new ViewHolder();
            view = activity.getLayoutInflater().inflate(item_layout, null);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        //binding data
        Product product = products.get(i);
        viewHolder.imvProductThumb.setImageResource(product.getProduct_Image());
        viewHolder.txtProductName.setText(product.getProduct_Name());
        viewHolder.txtProductSize.setText(product.getProduct_Size());
        viewHolder.txtProductColor.setText(product.getProduct_Color());
        viewHolder.txtProductPrice.setText("$" + String.valueOf(product.getProduct_Price()));
        viewHolder.txtProductQuantity.setText(String.valueOf(product.getProduct_Quantity()));

        return view;
    }

    class ViewHolder{
        ImageView imvProductThumb;
        TextView txtProductName, txtProductPrice, txtProductSize, txtProductColor, txtProductQuantity;
        CheckBox chkProduct;
    }
}

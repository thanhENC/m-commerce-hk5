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
import com.k20411group03.models.ProductModel;

import java.util.ArrayList;

public class ProductCollectionAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    ArrayList<ProductModel> productCollections;

    public ProductCollectionAdapter(Activity activity, int item_layout, ArrayList<ProductModel> productCollections) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.productCollections = productCollections;
    }

    @Override
    public int getCount() {
        return productCollections.size();
    }

    @Override
    public Object getItem(int i) {
        return productCollections.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            //link views
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

//set data
        ProductModel product = productCollections.get(i);
        holder.txtProductName.setText(product.getProductName());
        holder.txtProductPrice.setText(String.valueOf(product.getProductPrice()));
        //holder.imvProductImage.setImageResource(product.getProduct_Image());
        holder.imvProductImage.setImageResource(R.drawable.ic_launcher_background);

        return view;
    }

//    Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//    ImageView image = (ImageView) findViewById(R.id.imageView1);
//image.setImageBitmap(Bitmap.createScaledBitmap(bmp, image.getWidth(), image.getHeight(), false));

    public static class ViewHolder {
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice;
    }
}

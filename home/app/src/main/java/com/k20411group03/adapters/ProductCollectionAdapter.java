package com.k20411group03.adapters;

import static java.lang.Math.round;

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

    public static class ViewHolder {
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice, txtSalePrice, txtSalePercent;
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
            holder.txtSalePrice  = view.findViewById(R.id.txt_SalePrice);
            holder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);
            holder.txtSalePercent = view.findViewById(R.id.txt_SalePercent);
            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

//set data
        ProductModel product = productCollections.get(i);
        holder.txtProductName.setText(product.getProductName());
        holder.txtProductPrice.setText(String.valueOf(product.formatProductPrice(product.getProductPrice())) + " Đ");
        holder.txtSalePrice.setText(String.valueOf(product.formatProductPrice(product.getProductSalePrice())) + " Đ");
        holder.imvProductImage.setImageBitmap(convertByteArrayToBitmap(product.getProductImage()));
        holder.txtSalePercent.setText("-" + String.valueOf(round(
                (
                        (product.getProductPrice() - product.getProductSalePrice()) / product.getProductPrice())*100)) + "%");

        return view;
    }

    private Bitmap convertByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

//    Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//    ImageView image = (ImageView) findViewById(R.id.imageView1);
//image.setImageBitmap(Bitmap.createScaledBitmap(bmp, image.getWidth(), image.getHeight(), false));

}

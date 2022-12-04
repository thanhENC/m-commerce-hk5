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

import java.util.List;

public class FlashsaleAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ProductModel> flashsales;

    public FlashsaleAdapter(Activity activity, int item_layout, List<ProductModel> flashsales) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.flashsales = flashsales;
    }

    @Override
    public int getCount() {
        return flashsales.size();
    }

    @Override
    public Object getItem(int i) {
        return flashsales.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            //link views
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            viewHolder.txtProductName = view.findViewById(R.id.txt_ProductName);
            viewHolder.txtProductPrice = view.findViewById(R.id.txt_ProductPrice);
            viewHolder.txtProductPriceSale = view.findViewById(R.id.txt_ProductPriceSale);
            viewHolder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            viewHolder.txtFlashsaleQuantity = view.findViewById(R.id.txt_FlashsaleQuantity);
            viewHolder.txtFlashsalePercent = view.findViewById(R.id.txt_FlashsalePercent);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //binding data
        ProductModel flashsale = flashsales.get(i);

        //viewHolder.imvProductImage.setImageResource(R.drawable.cate_jacket);
        viewHolder.imvProductImage.setImageBitmap(convertByteArrayToBitmap(flashsale.getProductImage()));
        viewHolder.txtProductName.setText(flashsale.getProductName());
        viewHolder.txtProductPrice.setText(flashsale.formatProductPrice(flashsale.getProductPrice()) + " Đ");
        viewHolder.txtProductPriceSale.setText(flashsale.formatProductPrice(flashsale.getProductSalePrice()) + " Đ");
        viewHolder.txtFlashsaleQuantity.setText(String.valueOf(flashsale.getProductInventory()));
        viewHolder.txtFlashsalePercent.setText("-" + String.valueOf(round(
                (
                (flashsale.getProductPrice() - flashsale.getProductSalePrice()) / flashsale.getProductPrice())*100)) + "%");

        return view;
    }

    private Bitmap convertByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    class ViewHolder {
        public
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice, txtProductPriceSale, txtFlashsaleQuantity, txtFlashsalePercent;
    }

}
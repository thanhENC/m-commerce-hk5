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

import org.w3c.dom.Text;

import java.util.List;

public class WishlishAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ProductModel> products;

    public WishlishAdapter(Activity activity, int item_layout, List<ProductModel> products) {
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
        ViewHolder holder;

        if (view == null) {
            //link views
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            holder.imvProductImage = view.findViewById(R.id.imv_ProductImage);
            holder.txtProductName = view.findViewById(R.id.txt_ProductName);
            holder.txtSalePrice = view.findViewById(R.id.txt_SalePrice);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        //set data
        ProductModel product = products.get(i);
        holder.txtProductName.setText(product.getProductName());
        holder.txtSalePrice.setText(product.formatProductPrice(product.getProductSalePrice()) + " đ");
        holder.imvProductImage.setImageBitmap(product.getBitmapProductImage());

        return null;
    }

    public static class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtSalePrice;
    }
}

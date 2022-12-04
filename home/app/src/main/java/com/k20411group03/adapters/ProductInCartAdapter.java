package com.k20411group03.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.k20411group03.home.MainActivity;
import com.k20411group03.home.R;
import com.k20411group03.models.Product;
import com.k20411group03.models.ProductInCartModel;

import java.util.List;

public class ProductInCartAdapter extends BaseAdapter {
    //Đính Cart Activity trực tiếp
    MainActivity activity;
    int item_layout;
    List<ProductInCartModel> products;

    public ProductInCartAdapter(MainActivity activity, int item_layout, List<ProductInCartModel> products) {
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
        ViewHolder viewHolder;

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
            viewHolder.chkProductBuy = view.findViewById(R.id.chk_ProductBuy);

            view.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) view.getTag();
        }

        //binding data
        ProductInCartModel product = products.get(i);
        viewHolder.imvProductImage.setImageBitmap(product.getBitmapProductImage());
        viewHolder.txtProductName.setText(product.getProductName());
        viewHolder.txtProductSize.setText(product.getProductSize());
        viewHolder.txtProductColor.setText(product.getProductColor());
        viewHolder.txtProductPrice.setText(product.formatProductPrice(product.getProductSalePrice()));
        viewHolder.txtProductQuantity.setText(String.valueOf(product.getProductInventory()));
        viewHolder.chkProductBuy.setChecked(product.getProductIsChecked());

        //Nếu check vào checkbox sẽ cập nhật Tổng giá trị đơn hàng
//        viewHolder.chkProductBuy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//            }
//        });

        return view;
    }

    //ViewHolder
    class ViewHolder{
        ImageView imvProductImage;
        TextView txtProductName, txtProductPrice, txtProductSize, txtProductColor, txtProductQuantity;
        CheckBox chkProductBuy;
    }

    //Sum of all products in cart
    public double sumOfAllProductsInCart(){
        if (products.size() == 0){
            return 0;
        }
        else{
            double sum = 0;
            for (ProductInCartModel product : products){
                if(product.getProductIsChecked()){
                    sum += product.getProductSalePrice() * product.getProductInventory();
                }
            }
            return sum;
        }
    }
}

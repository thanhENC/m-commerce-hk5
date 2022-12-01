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
import com.k20411group03.models.Hangmoive;

import java.util.List;

public class HangmoiveAdapter  extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Hangmoive> hangmoives;

    public HangmoiveAdapter(Activity activity, int item_layout, List<Hangmoive> hangmoives) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.hangmoives = hangmoives;
    }

    @Override
    public int getCount() { return hangmoives.size();
    }

    @Override
    public Object getItem(int i) {
        return hangmoives.get(i);
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

            viewHolder.txtNewProductName = view.findViewById(R.id.txt_NewProductName);
            viewHolder.txtNewProductPrice = view.findViewById(R.id.txt_NewProductPrice);
            viewHolder.imvNewProductImage = view.findViewById(R.id.imv_NewProductImage);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        //binding data
        Hangmoive hangmoive = hangmoives.get(i);

        viewHolder.imvNewProductImage.setImageResource(hangmoive.getNewproduct_Image());
        viewHolder.txtNewProductName.setText(hangmoive.getNewproduct_Name());
        viewHolder.txtNewProductPrice.setText(String.valueOf(hangmoive.getNewproduct_Price()));

        return view;
    }
    class ViewHolder {
        public
        ImageView imvNewProductImage;
        TextView txtNewProductName, txtNewProductPrice;
    }

}

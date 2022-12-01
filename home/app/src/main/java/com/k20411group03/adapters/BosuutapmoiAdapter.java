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
import com.k20411group03.models.Bosuutapmoi;
import com.k20411group03.models.Hangmoive;

import java.util.List;

public class BosuutapmoiAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<Bosuutapmoi> bosuutapmois;

    public BosuutapmoiAdapter(Activity activity, int item_layout, List<Bosuutapmoi> bosuutapmois) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.bosuutapmois = bosuutapmois;
    }

    @Override
    public int getCount() {
        return bosuutapmois.size();
    }

    @Override
    public Object getItem(int i) {
        return bosuutapmois.get(i);
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
            viewHolder = new BosuutapmoiAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

            viewHolder.txtNewCollectionName = view.findViewById(R.id.txt_NewCollectionName);
            viewHolder.txtNewCollectionPrice = view.findViewById(R.id.txt_NewCollectionPrice);
            viewHolder.imvNewCollectionImage = view.findViewById(R.id.imv_NewCollectionImage);

            view.setTag(viewHolder);
        } else {
            viewHolder = (BosuutapmoiAdapter.ViewHolder) view.getTag();
        }

        //binding data
        Bosuutapmoi bosuutapmoi = bosuutapmois.get(i);

        viewHolder.imvNewCollectionImage.setImageResource(bosuutapmoi.getNewcollection_Image());
        viewHolder.txtNewCollectionName.setText(bosuutapmoi.getNewcollection_Name());
        viewHolder.txtNewCollectionPrice.setText(String.valueOf(bosuutapmoi.getNewcollection_Price()));

        return view;

    }

    class ViewHolder {
        public
        ImageView imvNewCollectionImage;
        TextView txtNewCollectionName, txtNewCollectionPrice;
    }
}

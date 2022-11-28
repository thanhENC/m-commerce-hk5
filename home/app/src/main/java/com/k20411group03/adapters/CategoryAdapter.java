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
import com.k20411group03.models.Item;
import com.k20411group03.models.Product;
import com.k20411group03.models.category;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<com.k20411group03.models.category> categoryList;

    public CategoryAdapter(Activity activity, int item_layout, List<category> categoryList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return categoryList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
        {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);

        }
        ImageView imv_cateThumb = view.findViewById(R.id.imv_cateThumb);
        TextView txt_cateName = view.findViewById(R.id.txt_cateName);
        category cate = categoryList.get(i);
        txt_cateName.setText(cate.getThumbName());
        imv_cateThumb.setImageResource(cate.getCateThumbID());
        return view;
    }
}

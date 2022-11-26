package com.k20411group03.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.k20411group03.home.Banners;
import com.k20411group03.home.R;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder>{

    ArrayList<Banners> bannerList;
    ViewPager viewPager;

    public BannerAdapter(ArrayList<Banners> bannerList) {
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Banners banner = bannerList.get(position);
        holder.imv_Banners.setImageResource(banner.getBannerId());
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imv_Banners;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imv_Banners = itemView.findViewById(R.id.imv_Banner);
        }
    }
}
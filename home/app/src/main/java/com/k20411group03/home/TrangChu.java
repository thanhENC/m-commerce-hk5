package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.k20411group03.adapters.BannerAdapter;
import com.k20411group03.adapters.ItemAdapter;
import com.k20411group03.home.R;
import com.k20411group03.models.Item;

import java.util.ArrayList;
import java.util.List;

public class TrangChu extends AppCompatActivity {
    ViewPager2 viewPager;
    ArrayList<Banners> bannerList;
    RecyclerView rcvFlashsale, rcvNewArrival, rcvForYou;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        //Set up Flash sale recyclerview
        rcvFlashsale = findViewById(R.id.rcv_Flashsale);
        ItemAdapter saleItemAdapter = new ItemAdapter(this);
        saleItemAdapter.setData(getListSaleItem());
        LinearLayoutManager saleLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvFlashsale.setLayoutManager(saleLayoutManager);
        rcvFlashsale.setAdapter(saleItemAdapter);

        //Set up New Arrival recyclerview
        rcvNewArrival = findViewById(R.id.rcv_NewArrival);
        ItemAdapter newItemAdapter = new ItemAdapter(this);
        newItemAdapter.setData(getListSaleItem());
        LinearLayoutManager newLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvFlashsale.setLayoutManager(saleLayoutManager);
        rcvNewArrival.setLayoutManager(newLayoutManager);
        rcvNewArrival.setAdapter(newItemAdapter);

        //Set up For you recyclerview
        rcvNewArrival = findViewById(R.id.rcv_ForYou);
        ItemAdapter foryouItemAdapter = new ItemAdapter(this);
        foryouItemAdapter.setData(getListSaleItem());
        LinearLayoutManager forYouLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvFlashsale.setLayoutManager(saleLayoutManager);
        rcvNewArrival.setLayoutManager(forYouLayoutManager);
        rcvNewArrival.setAdapter(foryouItemAdapter);

        //Set up viewpager
        bannerList = new ArrayList<>();
        viewPager = findViewById(R.id.vp_HomeBanner);
        int[] images = {R.drawable.img,R.drawable.img_1};
        for (int i =0; i< images.length ; i++){

            Banners banner = new Banners(images[i]);
            bannerList.add(banner);
        }
        BannerAdapter bannerAdapter =(BannerAdapter) new BannerAdapter(bannerList);
        viewPager.setAdapter(bannerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(2);
        viewPager.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);
        viewPager.setAdapter(bannerAdapter);
    }
    private List<Item> getListSaleItem(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.img_2,"Áo sơ mi caro",20000,170000,30.0,4.0,302,new String[]{"Red","Blue"},new String[]{"XL","L"}));
        list.add(new Item(R.drawable.img_2,"Áo sơ mi caro",20000,170000,30.0,4.0,302,new String[]{"Red","Blue"},new String[]{"XL","L"}));
        list.add(new Item(R.drawable.img_2,"Áo sơ mi caro",20000,170000,30.0,4.0,302,new String[]{"Red","Blue"},new String[]{"XL","L"}));
        list.add(new Item(R.drawable.img_2,"Áo sơ mi caro",20000,170000,30.0,4.0,302,new String[]{"Red","Blue"},new String[]{"XL","L"}));
        list.add(new Item(R.drawable.img_2,"Áo sơ mi caro",20000,170000,30.0,4.0,302,new String[]{"Red","Blue"},new String[]{"XL","L"}));
        list.add(new Item(R.drawable.img_2,"Áo sơ mi caro",20000,170000,30.0,4.0,302,new String[]{"Red","Blue"},new String[]{"XL","L"}));
        return list;
    }
}
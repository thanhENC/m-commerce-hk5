package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.k20411group03.adapters.BannerAdapter;
import com.k20411group03.adapters.CategoryAdapter;
import com.k20411group03.adapters.ItemRecyclerAdapter;
import com.k20411group03.models.Banners;
import com.k20411group03.models.Item;
import com.k20411group03.models.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TrangChu extends AppCompatActivity {
    ViewPager2 viewPager;
    ArrayList<Banners> bannerList;
    RecyclerView rcvFlashsale, rcvNewArrival, rcvForYou;
    GridView gvCategory;
    CategoryAdapter categoryAdapter;
    BottomNavigationView navigationView;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        //Set up Flash sale recyclerview
        rcvFlashsale = findViewById(R.id.rcv_Flashsale);
        ItemRecyclerAdapter saleItemAdapter = new ItemRecyclerAdapter(this);
        saleItemAdapter.setData(getListSaleItem());
        LinearLayoutManager saleLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvFlashsale.setLayoutManager(saleLayoutManager);
        rcvFlashsale.setAdapter(saleItemAdapter);

        //Gridview category
        gvCategory = findViewById(R.id.gv_Category);
        categoryAdapter = new CategoryAdapter(TrangChu.this,R.layout.category_layout,getCategory());
        gvCategory.setAdapter(categoryAdapter);

        //Set up New Arrival recyclerview
        rcvNewArrival = findViewById(R.id.rcv_NewArrival);
        ItemRecyclerAdapter newItemAdapter = new ItemRecyclerAdapter(this);
        newItemAdapter.setData(getListSaleItem());
        LinearLayoutManager newLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvNewArrival.setLayoutManager(newLayoutManager);
        rcvNewArrival.setAdapter(newItemAdapter);

        //Set up For you recyclerview
        rcvForYou = findViewById(R.id.rcv_ForYou);
        ItemRecyclerAdapter foryouItemAdapter = new ItemRecyclerAdapter(this);
        foryouItemAdapter.setData(getListSaleItem());
        LinearLayoutManager forYouLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvForYou.setLayoutManager(forYouLayoutManager);
        rcvForYou.setAdapter(foryouItemAdapter);

        //Set up viewpager
        bannerList = new ArrayList<>();
        viewPager = findViewById(R.id.vp_HomeBanner);
        int[] images = {R.drawable.banner2,R.drawable.banner1,R.drawable.banner3};
        for (int i =0; i< images.length ; i++){

            Banners banner = new Banners(images[i]);
            bannerList.add(banner);
        }
        BannerAdapter bannerAdapter =(BannerAdapter) new BannerAdapter(bannerList);
        viewPager.setAdapter(bannerAdapter);




        autoSlide();
        addEvents();

    }

    private List<Item> getListSaleItem(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));
        list.add(new Item(1,1,"Áo sơ mi ca rô xanh rêu nhạt",150,R.drawable.somi,"Áo sơ mi caro",200000,300000,33,4.5,29,new String[]{"Red","Blue"},new String[]{"M","L","XL"}));



        return list;
    }

    private List<category> getCategory (){
        List<category> cateList =new ArrayList<>();
        cateList.add(new category(1,R.drawable.cate_tshirt,"Áo thun"));
        cateList.add(new category(2,R.drawable.cate_polo,"Áo polo"));
        cateList.add(new category(3,R.drawable.cate_shirt,"Áo sơ mi"));
        cateList.add(new category(4,R.drawable.cate_jacket,"Áo khoác"));
        cateList.add(new category(5,R.drawable.cate_jean,"Quần jean"));
        cateList.add(new category(6,R.drawable.cateeasypant,"Quần âu"));
        cateList.add(new category(7,R.drawable.cate_kaki,"Quần kaki"));
        cateList.add(new category(8,R.drawable.shortpant,"Quần short"));
        return cateList;
    }

    private void autoSlide(){
        if(bannerList == null || bannerList.isEmpty() || viewPager == null){
            return;
        }
        if(timer == null){
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = bannerList.size() - 1;
                        if(currentItem < totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else{viewPager.setCurrentItem(0);}
                    }
                });

            }
        }, 1000, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(timer != null){
            timer.cancel();
            timer =null;
        }
    }

    private void addEvents(){
        navigationView = findViewById(R.id.mn_home);
        navigationView.setSelectedItemId(R.id.item_home);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_home:
                        return true;
                    case  R.id.item_member1:
                        Intent intent1 = new Intent(getApplicationContext(),member1.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_noti:
                        Intent intent2 =new Intent(getApplicationContext(),ThongBao.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_scan:
                        Intent intent3 =new Intent(getApplicationContext(),scan1.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_wishlist:
                        Intent intent4 =new Intent(getApplicationContext(),Wishlist.class);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent4);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        gvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                category c = (category) gvCategory.getItemAtPosition(i);
                int cateID = c.getCateID();
                int thumbID = c.getCateThumbID();
                String cateName = c.getThumbName();
                Intent intent = new Intent(TrangChu.this,DanhMuc.class);
                intent.putExtra("Cate", cateID);
                startActivity(intent);
            }
        });

    }
}
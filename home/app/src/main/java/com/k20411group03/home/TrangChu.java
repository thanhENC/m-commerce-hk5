package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.k20411group03.Utils;
import com.k20411group03.adapters.BannerAdapter;
import com.k20411group03.adapters.CategoryAdapter;
import com.k20411group03.adapters.ItemRecyclerAdapter;
import com.k20411group03.models.Banners;
import com.k20411group03.models.Item;
import com.k20411group03.models.ProductModel;
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
    public static SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        //Custom action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

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

    //Thêm action
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Sự kiện action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intentSearch = new Intent(TrangChu.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(TrangChu.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_BoSuuTap:
                Intent intentBoSuuTap = new Intent(TrangChu.this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "Bộ sưu tập mới");
                startActivity(intentBoSuuTap);
                break;
            case R.id.action_HangMoiVe:
                Intent intentSanPhamMoi = new Intent(TrangChu.this, ProductCollection.class);
                intentSanPhamMoi.putExtra("screenTitle", "Hàng mới về");
                startActivity(intentSanPhamMoi);
                break;
            case R.id.action_Flashsale:
                Intent intentFlashsale = new Intent(TrangChu.this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
                break;
            case R.id.action_SanPham:
                Intent intentSanPham = new Intent(TrangChu.this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "Sản phẩm");
                startActivity(intentSanPham);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ProductModel> getListSaleItem(){
        List<ProductModel> list = new ArrayList<>();
        //get top 10 item from database
        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);
        //get top 10 item from database
        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " ORDER BY " + Utils.COL_SALEPRICE + " DESC LIMIT 10", null);
        //Thêm ProductModel vào list
        while (c.moveToNext()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            String Cate = c.getString(2);
            byte[] thumb = c.getBlob(3);
            double price = c.getDouble(4);
            double salePrice = c.getDouble(5);
            String description = c.getString(6);
            int inventory = c.getInt(7);
            ProductModel productModel = new ProductModel(id, name, Cate, thumb, price, salePrice, description, inventory);
            list.add(productModel);
        }
        return list;
    }

    private List<category> getCategory (){
        List<category> cateList =new ArrayList<>();
        cateList.add(new category("AT",R.drawable.cate_tshirt,"Áo thun"));
        cateList.add(new category("PL",R.drawable.cate_polo,"Áo polo"));
        cateList.add(new category("SM",R.drawable.cate_shirt,"Áo sơ mi"));
        cateList.add(new category("AK",R.drawable.cate_jacket,"Áo khoác"));
        cateList.add(new category("JE",R.drawable.cate_jean,"Quần jean"));
        cateList.add(new category("TA",R.drawable.cateeasypant,"Quần âu"));
        cateList.add(new category("KK",R.drawable.cate_kaki,"Quần kaki"));
        cateList.add(new category("SH",R.drawable.shortpant,"Quần short"));
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

        //Sự kiện khi click vào sale banner
        Button btnSale = findViewById(R.id.btn_SaleBanner);
        btnSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSale = new Intent(TrangChu.this, FlashSaleScreen.class);
                startActivity(intentSale);
            }
        });

        //Sự kiện khi click vào xem thêm flash sale
        TextView txtNavFlashsale = findViewById(R.id.txt_navFlashSale);
        txtNavFlashsale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFlashsale = new Intent(TrangChu.this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
            }
        });

        //Sự kiện khi click vào xem thêm sản phẩm mới
        TextView txtNavSanPham = findViewById(R.id.txt_navNewArrival);
        txtNavSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSanPham = new Intent(TrangChu.this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "Hàng mới về");
                startActivity(intentSanPham);
            }
        });

        //Sự kiện khi click vào xem thêm bộ sưu tập
        TextView txtNavBoSuuTap = findViewById(R.id.txt_navForYou);
        txtNavBoSuuTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBoSuuTap = new Intent(TrangChu.this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "Bộ sưu tập mới");
                startActivity(intentBoSuuTap);
            }
        });




        //Sự kiện khi click vào navigation bar
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


        //Sự kiện khi click vào các item trong danh mục
        gvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                category c = (category) gvCategory.getItemAtPosition(i);
                String cateID = c.getCateID();
                Intent intent = new Intent(TrangChu.this,DanhMuc.class);
                intent.putExtra("Cate", cateID);
                startActivity(intent);
            }
        });


        //click vào viewpager chuyển sang trang bộ sưu tập (chưa xong)
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangChu.this,ProductCollection.class);
                startActivity(intent);
            }
        });
    }
}
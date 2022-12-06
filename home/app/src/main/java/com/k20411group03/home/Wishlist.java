package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.k20411group03.CustomerData;
import com.k20411group03.Utils;
import com.k20411group03.adapters.ProductCollectionAdapter;
import com.k20411group03.adapters.WishlishAdapter;
import com.k20411group03.home.databinding.ActivityWishlistBinding;
import com.k20411group03.models.ProductModel;

import java.util.ArrayList;

public class Wishlist extends AppCompatActivity {
    BottomNavigationView navigationView;
    ActivityWishlistBinding binding;
    WishlishAdapter adapter;

    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_wishlist);
        binding = ActivityWishlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//         //Custom action bar
//         ActionBar actionBar = getSupportActionBar();
//         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//         actionBar.setDisplayShowCustomEnabled(true);
//         actionBar.setCustomView(R.layout.custom_action_bar);
//         actionBar.setDisplayUseLogoEnabled(true);
//         actionBar.setDisplayShowHomeEnabled(true);

        loadData();
        addEvents();
    }
// load data

    private void loadData() {
        if (CustomerData.wishlist.size() == 0){
            db =  openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);
//        db.rawQuery("select * from PRODUCT where ProductID in (select ProductID from WISHLIST WHERE CustomerID = 5)", null);

            Cursor c =  db.rawQuery("select * from " + Utils.TBL_NAME+ " where " + Utils.COL_ID + " in (select " + Utils.Wishlist.COL_PRODUCTID  + " from " + Utils.Wishlist.TBL_NAME + " WHERE " + Utils.Wishlist.COL_CUSTOMERID +" = " + CustomerData.info.USER_ID + ")", null);
            int id;
            String name;
            byte[] image;
            Double salePrice;
            while (c.moveToNext()) {
                id = c.getInt(0);
                name = c.getString(1);
                image = c.getBlob(3);
                salePrice = c.getDouble(5);

                CustomerData.insertToWishlist(new ProductModel(id, name, null, image, null, salePrice, null, 1));
            }
            c.close();
        }

        adapter = new WishlishAdapter(this, R.layout.item_wishlist, CustomerData.wishlist);
        binding.lvProductCollection.setAdapter(adapter);
    }

//     //Thêm action
//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {

//         getMenuInflater().inflate(R.menu.main, menu);
//         return super.onCreateOptionsMenu(menu);
//     }

//     //Sự kiện action bar
//     @Override
//     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//         switch (item.getItemId()) {
//             case R.id.action_search:
//                 Intent intentSearch = new Intent(Wishlist.this, ActivitySearch.class);
//                 startActivity(intentSearch);
//                 break;
//             case R.id.action_cart:
//                 Intent intentCart = new Intent(Wishlist.this, MainActivity.class);
//                 startActivity(intentCart);
//                 break;
//             case R.id.action_menu:
//                 Intent intentMenu = new Intent(Wishlist.this, MainMenu.class);
//                 startActivity(intentMenu);
//                 break;
//         }

//         return super.onOptionsItemSelected(item);
//     }

    private void addEvents(){
        //Bottom navigation
        navigationView = findViewById(R.id.mn_wishlist);
        navigationView.setSelectedItemId(R.id.item_wishlist);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.item_wishlist:
                        return true;
                    case R.id.item_scan:
                        Intent intent1 = new Intent(getApplicationContext(),scan1.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_member1:
                        Intent intent2 = new Intent(getApplicationContext(),member1.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_noti:
                        Intent intent3 =new Intent(getApplicationContext(),ThongBao.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_home:
                        Intent intent4 =new Intent(getApplicationContext(),TrangChu.class);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent4);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }
}

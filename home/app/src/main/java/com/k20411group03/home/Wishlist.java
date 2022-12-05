package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Wishlist extends AppCompatActivity {
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

//         //Custom action bar
//         ActionBar actionBar = getSupportActionBar();
//         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//         actionBar.setDisplayShowCustomEnabled(true);
//         actionBar.setCustomView(R.layout.custom_action_bar);
//         actionBar.setDisplayUseLogoEnabled(true);
//         actionBar.setDisplayShowHomeEnabled(true);

        addEvents();
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
}

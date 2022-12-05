package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.k20411group03.home.R;
import com.k20411group03.home.databinding.ActivityMainMenuBinding;

public class MainMenu extends AppCompatActivity {

    ActivityMainMenuBinding binding;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_menu);

        //Custom action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                Intent intentSearch = new Intent(MainMenu.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(MainMenu.this, MainActivity.class);
                startActivity(intentCart);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addEvents() {
        binding.txtHangMoiVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Danh Mục Nổi Bật - Hàng Mới Về
                Intent intent = new Intent(MainMenu.this, ProductCollection.class);
                intent.putExtra("screenTitle", "Hàng mới về");
                startActivity(intent);
            }
        });

        binding.txtBoSuuTapMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Bộ Sưu Tập Mới
                Intent intent = new Intent(MainMenu.this, ProductCollection.class);
                intent.putExtra("screenTitle", "Bộ sưu tập mới");
                startActivity(intent);
            }
        });

        binding.txtFlashSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Flash Sale
                intent = new Intent(MainMenu.this, FlashSaleScreen.class);
                startActivity(intent);
            }
        });

        binding.txtSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Sản Phẩm
                intent = new Intent(MainMenu.this, ProductCollection.class);
                intent.putExtra("screenTitle", "Sản phẩm");
                startActivity(intent);
            }
        });

        binding.txtLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Liên Hệ
            }
        });
    }
}
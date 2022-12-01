package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.txtHangMoiVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Danh Mục Nổi Bật - Hàng Mới Về
                Intent intent = new Intent(MainMenu.this, homescreen.class);
                startActivity(intent);

            }
        });

        binding.txtBoSuuTapMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Bộ Sưu Tập Mới
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
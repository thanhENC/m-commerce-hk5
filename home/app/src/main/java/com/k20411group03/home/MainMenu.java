package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.k20411group03.home.R;
import com.k20411group03.home.databinding.ActivityMainMenuBinding;

public class MainMenu extends AppCompatActivity {

    ActivityMainMenuBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_menu);

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.lnlHangMoiVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Danh Mục Nổi Bật - Hàng Mới Về
            }
        });

        binding.lnlBoSuuTapMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Bộ Sưu Tập Mới
            }
        });

        binding.lnlFlashSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Flash Sale
            }
        });

        binding.lnlSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Sản Phẩm
            }
        });

        binding.lnlLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Mở màn hình Liên Hệ
            }
        });
    }
}
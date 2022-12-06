package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.k20411group03.home.databinding.ActivityMacDinhMemberBinding;

public class MacDinhMember extends AppCompatActivity {
    ActivityMacDinhMemberBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMacDinhMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();

        //setContentView(R.layout.activity_mac_dinh_member);
    }

    private void setListeners() {
        binding.buttonDangKy.setOnClickListener(v -> {
            //Open activity 2
            Intent intent = new Intent(MacDinhMember.this, DangKy.class);
            startActivity(intent);
        });
        binding.buttonDangNhap.setOnClickListener(v -> {
            //Open activity 2
            Intent intent = new Intent(MacDinhMember.this, dangnhap1.class);
            startActivity(intent);
        });
    }
}
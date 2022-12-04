package com.k20411group03.home;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.k20411group03.home.databinding.ActivityMember1Binding;

public class member1 extends AppCompatActivity {
    ActivityMember1Binding binding;
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_member1);
        binding= ActivityMember1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }
    private void addEvents(){
        //Bottom navigation
        //navigationView = findViewById(R.id.mn_membership);
        navigationView = binding.mnMembership;
        navigationView.setSelectedItemId(R.id.item_member1);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.item_member1:
                        return true;
                    case R.id.item_scan:
                        Intent intent = new Intent(getApplicationContext(),scan1.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case  R.id.item_wishlist:
                        Intent intent1 = new Intent(getApplicationContext(),Wishlist.class);
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
                    case  R.id.item_home:
                        Intent intent3 =new Intent(getApplicationContext(),TrangChu.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //Button Đăng xuất
        binding.btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(member1.this);
                dialog.setContentView(R.layout.dialog_dangxuat);
                dialog.setCanceledOnTouchOutside(false);
                TextView txtDangXuat = dialog.findViewById(R.id.txtYes);
                txtDangXuat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(member1.this, TrangChu.class);
                        startActivity(intent);
                    }
                });
                TextView txtHuy = dialog.findViewById(R.id.txtQuit);
                txtHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
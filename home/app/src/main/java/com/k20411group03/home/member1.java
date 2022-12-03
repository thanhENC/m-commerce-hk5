package com.k20411group03.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.k20411group03.home.databinding.ActivityMember1Binding;
import com.k20411group03.home.databinding.ActivityVoucherMainBinding;

public class member1 extends AppCompatActivity {
    ActivityMember1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_member1);
        binding= ActivityMember1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open activity 2
                Intent intent = new Intent(member1.this, TrangChu.class);
                startActivity(intent);
            }
        });
    }
}
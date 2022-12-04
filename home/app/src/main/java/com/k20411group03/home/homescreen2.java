package com.k20411group03.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.k20411group03.home.databinding.ActivityHomescreen2Binding;
import com.k20411group03.home.databinding.ActivityHomescreenBinding;

public class homescreen2 extends AppCompatActivity {
    ActivityHomescreen2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen2);
        binding = ActivityHomescreen2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(homescreen2.this,TrangChu.class);
                startActivity(intent);
            }
        });
    }
}
package com.k20411group03.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.k20411group03.home.databinding.ActivityHomescreenBinding;

public class homescreen extends AppCompatActivity {
    ActivityHomescreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Log.i("HomeScreen","onCreate");
        binding = ActivityHomescreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
        binding.btnKhamPha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening activity 2
                Intent intent = new Intent(homescreen.this,homescreen2.class);
                startActivity(intent);
            }
        });
    }


}

package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k20411group03.home.databinding.ActivityFilterBinding;

public class Filter extends AppCompatActivity {

    ActivityFilterBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sort);

        binding = ActivityFilterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
}

    private void addEvents() {
        binding.btnFilterConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Filter.this, ProductCollection.class);
                startActivity(intent);
            }
        });
    }
}




package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.os.Bundle;
import android.widget.Adapter;

import com.k20411group03.adapters.HangmoiveAdapter;
import com.k20411group03.home.databinding.ActivityNewProductBinding;
import com.k20411group03.models.Hangmoive;

import java.util.ArrayList;

public class NewProduct extends AppCompatActivity {

    ActivityNewProductBinding binding;
    HangmoiveAdapter adapter;
    ArrayList<Hangmoive> listHangmoive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_new_product);
        binding = ActivityNewProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        listHangmoive = new ArrayList<>();
        listHangmoive.add(new Hangmoive("San Pham 1 ", 10000000, R.drawable.nen));
        listHangmoive.add(new Hangmoive("San Pham 2 ", 10000000, R.drawable.nen));
        listHangmoive.add(new Hangmoive("San Pham 3 ", 10000000, R.drawable.nen));
        listHangmoive.add(new Hangmoive("San Pham 4 ", 10000000, R.drawable.nen));

        adapter = new HangmoiveAdapter(NewProduct.this, R.layout.item_list_hangmoive, listHangmoive);
        binding.lvHangmoive.setAdapter(adapter);
    }

}
package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k20411group03.adapters.FlashsaleAdapter;
import com.k20411group03.home.databinding.ActivityFlashSaleScreenBinding;
import com.k20411group03.models.Flashsale;

import java.util.ArrayList;
import java.util.List;

public class FlashSaleScreen extends AppCompatActivity {

    ActivityFlashSaleScreenBinding binding;
    FlashsaleAdapter adapter;
    List<Flashsale> flashsales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityFlashSaleScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        flashsales = new ArrayList<>();

        flashsales.add(new Flashsale("Áo đá banh", 500000,400000 , R.drawable.ic_baseline_image_24, 100, "-10%" ));
        flashsales.add(new Flashsale("Áo đá bóng", 400000,300000 , R.drawable.ic_baseline_image_24, 80, "-25%" ));
        flashsales.add(new Flashsale("Áo cầu thủ", 200000,150000 , R.drawable.ic_baseline_image_24, 15, "-25%" ));
        flashsales.add(new Flashsale("Áo số quần đùi", 1000000,700000 , R.drawable.ic_baseline_image_24, 420, "-30%" ));

        adapter = new FlashsaleAdapter(FlashSaleScreen.this, R.layout.flash_sale_item, flashsales);
        binding.lvFlashsale.setAdapter(adapter);
    }
}
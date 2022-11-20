package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.k20411group03.adapters.PaymentItemAdapter;
import com.k20411group03.adapters.ProductAdapter;
import com.k20411group03.home.databinding.ActivityThanhToanPreBinding;
import com.k20411group03.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanPre extends AppCompatActivity {

    ActivityThanhToanPreBinding binding;
    PaymentItemAdapter adapter;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_thanh_toan_pre);

        binding = ActivityThanhToanPreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        products = new ArrayList<>();

        products.add(new Product("Product 1", 100, R.drawable.ic_baseline_image_24, "S", "Red", 1, false));
        products.add(new Product("Product 2", 200, R.drawable.ic_baseline_image_24, "M", "Blue", 2, false));
        products.add(new Product("Product 3", 300, R.drawable.ic_baseline_image_24, "L", "Green", 3, false));
        products.add(new Product("Product 4", 400, R.drawable.ic_baseline_image_24, "XL", "Yellow", 4, false));
        products.add(new Product("Product 5", 500, R.drawable.ic_baseline_image_24, "XXL", "Black", 5, false));
        products.add(new Product("Product 6", 600, R.drawable.ic_baseline_image_24, "XXXL", "White", 6, false));
        products.add(new Product("Product 7", 700, R.drawable.ic_baseline_image_24, "S", "Red", 7, false));
        products.add(new Product("Product 8", 800, R.drawable.ic_baseline_image_24, "M", "Blue", 8, false));
        products.add(new Product("Product 9", 900, R.drawable.ic_baseline_image_24, "L", "Green", 9, false));
        products.add(new Product("Product 10", 1000, R.drawable.ic_baseline_image_24, "XL", "Yellow", 10, false));

        adapter = new PaymentItemAdapter(ThanhToanPre.this, R.layout.paymentitem, products);
        binding.lvGioHang.setAdapter(adapter);
    }
}
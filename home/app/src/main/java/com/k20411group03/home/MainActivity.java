package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.k20411group03.adapters.ProductAdapter;
import com.k20411group03.home.databinding.ActivityMainBinding;
import com.k20411group03.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
//    ActivityResultLauncher<Intent> launcher;
    ProductAdapter adapter;
    List<Product> products;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
        getData();

//        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
//            if(result.getResultCode()== RESULT_OK && result.getData() != null){
//                int pow = result.getData().getIntExtra("pow", 0);
//                binding.txtResult.setText(String.valueOf(pow));
//            }
//        });
    }

    private void getData() {
        intent = getIntent();
        //int numb = Integer.parseInt(intent.getStringExtra("numb"));
        binding.customersurname.setText(intent.getStringExtra("Ho"));
        binding.customerfirstname.setText(intent.getStringExtra("Ten"));
        binding.phonenumber.setText(intent.getStringExtra("Phone"));
        binding.address.setText(intent.getStringExtra("Province"));
        binding.noteaddress.setText(intent.getStringExtra("Note"));
        binding.txtPhuongthucthanhtoan.setText(intent.getStringExtra("Payment"));

    }

    private void addEvents() {
        binding.btnAddress.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Open Dia Chi Nhan Hang
                Intent intent = new Intent (MainActivity.this,DiaChiNhanHang.class);
                startActivity(intent);
            }
        });

        binding.txtPhuongthucthanhtoan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Open Phuong thuc thanh toan
                Intent intent = new Intent (MainActivity.this,ThanhToan.class);
                startActivity(intent);
            }
        });
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

        adapter = new ProductAdapter(MainActivity.this, R.layout.cartitem, products);
        binding.lvGioHang.setAdapter(adapter);
    }
}
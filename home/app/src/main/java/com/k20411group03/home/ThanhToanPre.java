package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;

import com.k20411group03.adapters.PaymentItemAdapter;
import com.k20411group03.home.databinding.ActivityThanhToanPreBinding;
import com.k20411group03.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanPre extends AppCompatActivity {

    ActivityThanhToanPreBinding binding;
    PaymentItemAdapter adapter;
    List<Product> products;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_thanh_toan_pre);

        //Custom action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        binding = ActivityThanhToanPreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
        getData();
    }

    private void getData() {

        Intent intent = getIntent();
        binding.txtNguoiNhanSDT.setText( intent.getStringExtra("Ho") + " " + intent.getStringExtra("Ten") + " | " + intent.getStringExtra("Phone"));
        binding.txtAddress.setText(intent.getStringExtra("Street") + ", " + intent.getStringExtra("Ward") + ", " + intent.getStringExtra("District") + ", " + intent.getStringExtra("Province"));
    }

    private void addEvents() {

        binding.txtTitleDiaChi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Open Dia Chi Nhan Hang
                Intent intent = new Intent (ThanhToanPre.this, DiaChiNhanHang.class);
                startActivity(intent);

            }
        });

        binding.txtPTThanhToan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Open Phuong thuc thanh toan
                Intent intent = new Intent (ThanhToanPre.this,ThanhToan.class);
                startActivity(intent);
            }
        });
    }



    //Thêm action
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Sự kiện action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intentSearch = new Intent(ThanhToanPre.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(ThanhToanPre.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_menu:
                Intent intentMenu = new Intent(ThanhToanPre.this, MainMenu.class);
                startActivity(intentMenu);
                break;
        }

        return super.onOptionsItemSelected(item);
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
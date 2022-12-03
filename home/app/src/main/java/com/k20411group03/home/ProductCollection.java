package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.k20411group03.adapters.ProductCollectionAdapter;
import com.k20411group03.home.databinding.ActivityProductCollectionBinding;
import com.k20411group03.models.ProductModel;

import java.util.ArrayList;

public class ProductCollection extends AppCompatActivity {

//    ActivityProductCollectionBinding binding;
//    BosuutapmoiAdapter adapter;
//    ArrayList<Bosuutapmoi> listProduct;
//
//    Intent intent;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_new_collection);
//        binding = ActivityProductCollectionBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        loadData();
//    }
//
//    private void loadData() {
//        intent = getIntent();
//        String screenTitle = intent.getStringExtra("screenTitle");
//        if(screenTitle != null){
//            binding.tvTitle.setText(screenTitle.toUpperCase());
//
//            if(screenTitle == "Bộ sưu tập mới"){
//                listProduct = new ArrayList<>();
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 1", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 2", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 3", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 4", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 5", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 6", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 7", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 8", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 9", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Bo Suu Tap 10", 250000, R.drawable.nen));
//
//                adapter = new BosuutapmoiAdapter(ProductCollection.this, R.layout.item_list_bosuutapmoi, listProduct);
//                binding.lvProductCollection.setAdapter(adapter);
//            }
//            else if(screenTitle == "Hàng mới về"){
//                listProduct = new ArrayList<>();
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 1", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 2", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 3", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 4", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 5", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 6", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 7", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 8", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 9", 250000, R.drawable.nen));
//                listProduct.add(new Bosuutapmoi("SP Hang Moi Ve 10", 250000, R.drawable.nen));
//
//                adapter = new BosuutapmoiAdapter(ProductCollection.this, R.layout.item_list_bosuutapmoi, listProduct);
//                binding.lvProductCollection.setAdapter(adapter);
//            }
//        }
//    }

    ActivityProductCollectionBinding binding;
    ProductCollectionAdapter adapter;
    ArrayList<ProductModel> listProduct;

    ProductModel selectedProduct = null;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_new_collection);
        binding = ActivityProductCollectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvProductCollection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedProduct = listProduct.get(position);

                //INTENT ĐẾN MÀN HÌNH CHI TIẾT SẢN PHẨM

                //intent = new Intent(ProductCollection.this, ProductDetail.class);
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("selectedProduct", (Serializable) selectedProduct);
                //intent.putExtras(bundle);
                //startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    private void loadData() {
        listProduct = new ArrayList<>();

        intent = getIntent();
        String screenTitle = intent.getStringExtra("screenTitle");

        if(screenTitle != null){
            binding.txtTitle.setText(screenTitle.toUpperCase());
            if(screenTitle.equals("Bộ sưu tập mới")){
                listProduct.add(new ProductModel(100, "Bộ sưu tập mới 1", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(101, "Bộ sưu tập mới 2", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(102, "Bộ sưu tập mới 3", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(103, "Bộ sưu tập mới 4", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(104, "Bộ sưu tập mới 5", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
            }
            else if(screenTitle.equals("Hàng mới về")){
                listProduct.add(new ProductModel(100, "Hàng mới về 1", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(101, "Hàng mới về 2", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(102, "Hàng mới về 3", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(103, "Hàng mới về 4", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(104, "Hàng mới về 5", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
            }
            else if(screenTitle.equals("Sản phẩm")){
                listProduct.add(new ProductModel(100, "San pham 1", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(101, "San pham 2", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(102, "San pham 3", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(103, "San pham 4", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
                listProduct.add(new ProductModel(104, "San pham 5", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
            }
        }
        else{
            binding.txtTitle.setText("SẢN PHẨM");
            listProduct.add(new ProductModel(103, "San pham null 1", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
            listProduct.add(new ProductModel(104, "San pham null 2", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
            listProduct.add(new ProductModel(105, "San pham null 3", "AT", null, 250000.0, 200000.0, "Áo thun cotton đến từ The Weekdays", 25));
        }

        adapter = new ProductCollectionAdapter(ProductCollection.this, R.layout.item_list_product, listProduct);
        binding.lvProductCollection.setAdapter(adapter);
    }
}
package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.k20411group03.Utils;
import com.k20411group03.adapters.FlashsaleAdapter;
import com.k20411group03.adapters.ProductCollectionAdapter;
import com.k20411group03.home.databinding.ActivityProductCollectionBinding;
import com.k20411group03.models.Flashsale;
import com.k20411group03.models.ProductModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductCollection extends AppCompatActivity {

    ActivityProductCollectionBinding binding;
    ProductCollectionAdapter adapter;
    ArrayList<ProductModel> listProduct;

    public static SQLiteDatabase db;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_new_collection);
        binding = ActivityProductCollectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.lvProductCollection);

        loadData();
        addEvents();
    }

    private void addEvents() {
        binding.lvProductCollection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductModel selectedProduct = listProduct.get(position);

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

        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);

        intent = getIntent();
        String screenTitle = intent.getStringExtra("screenTitle");

        if(screenTitle != null){
            binding.txtTitle.setText(screenTitle.toUpperCase());
            if(screenTitle.equals("Bộ sưu tập mới")){
                Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE(" + Utils.COL_CATEGORY + " = 'PL')",null);
                int count = c.getCount();

                binding.txtNumberOfProduct.setText(String.valueOf(count) + " SẢN PHẨM");

                int productID;
                String productName;
                String categoryID;
                byte[] productImage;
                Double productPrice;
                Double productSalePrice;
                String productDescription;
                int productInventory;
                while (c.moveToNext()) {
                    productID = c.getInt(0);
                    productName = c.getString(1);
                    categoryID = c.getString(2);
                    productImage = c.getBlob(3);
                    productPrice = c.getDouble(4);
                    productSalePrice = c.getDouble(5);
                    productDescription = c.getString(6);
                    productInventory = c. getInt(7);

                    listProduct.add(new ProductModel(productID, productName, categoryID, productImage, productPrice, productSalePrice, productDescription, productInventory));
                }

                //Đóng database để giải phóng bộ nhớ:
                c.close();
            }
            else if(screenTitle.equals("Hàng mới về")){

//                List<Integer> hangmoive = new ArrayList<Integer>;
//                hangmoive = Arrays.asList(100, 101, 112, 113, 114, 121, 122, 131, 132, 200, 201, 210, 211, 219, 220, 229, 230);

                Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE(" + Utils.COL_ID + " IN (100, 101, 112, 113, 114, 121, 122, 131, 132, 200, 201, 210, 211, 219, 220, 229, 230))",null);
                int count = c.getCount();

                binding.txtNumberOfProduct.setText(String.valueOf(count) + " SẢN PHẨM");

                int productID;
                String productName;
                String categoryID;
                byte[] productImage;
                Double productPrice;
                Double productSalePrice;
                String productDescription;
                int productInventory;
                while (c.moveToNext()) {
                    productID = c.getInt(0);
                    productName = c.getString(1);
                    categoryID = c.getString(2);
                    productImage = c.getBlob(3);
                    productPrice = c.getDouble(4);
                    productSalePrice = c.getDouble(5);
                    productDescription = c.getString(6);
                    productInventory = c. getInt(7);

                    listProduct.add(new ProductModel(productID, productName, categoryID, productImage, productPrice, productSalePrice, productDescription, productInventory));
                }

                //Đóng database để giải phóng bộ nhớ:
                c.close();
            }
            else if(screenTitle.equals("Sản phẩm")){
                Cursor c = db.query(Utils.TBL_NAME, null, null, null, null, null, null);;
                int count = c.getCount();

                binding.txtNumberOfProduct.setText(String.valueOf(count) + " SẢN PHẨM");

                int productID;
                String productName;
                String categoryID;
                byte[] productImage;
                Double productPrice;
                Double productSalePrice;
                String productDescription;
                int productInventory;
                while (c.moveToNext()) {
                    productID = c.getInt(0);
                    productName = c.getString(1);
                    categoryID = c.getString(2);
                    productImage = c.getBlob(3);
                    productPrice = c.getDouble(4);
                    productSalePrice = c.getDouble(5);
                    productDescription = c.getString(6);
                    productInventory = c. getInt(7);

                    listProduct.add(new ProductModel(productID, productName, categoryID, productImage, productPrice, productSalePrice, productDescription, productInventory));
                }

                //Đóng database để giải phóng bộ nhớ:
                c.close();

            }
        }
        else{
            Cursor c = db.query(Utils.TBL_NAME, null, null, null, null, null, null);;
            int count = c.getCount();

            binding.txtNumberOfProduct.setText(String.valueOf(count) + " SẢN PHẨM");

            int productID;
            String productName;
            String categoryID;
            byte[] productImage;
            Double productPrice;
            Double productSalePrice;
            String productDescription;
            int productInventory;
            while (c.moveToNext()) {
                productID = c.getInt(0);
                productName = c.getString(1);
                categoryID = c.getString(2);
                productImage = c.getBlob(3);
                productPrice = c.getDouble(4);
                productSalePrice = c.getDouble(5);
                productDescription = c.getString(6);
                productInventory = c. getInt(7);

                listProduct.add(new ProductModel(productID, productName, categoryID, productImage, productPrice, productSalePrice, productDescription, productInventory));
            }

            //Đóng database để giải phóng bộ nhớ:
            c.close();
        }

        adapter = new ProductCollectionAdapter(ProductCollection.this, R.layout.item_list_product, listProduct);
        binding.lvProductCollection.setAdapter(adapter);
    }
}
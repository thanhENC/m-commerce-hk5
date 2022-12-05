package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.k20411group03.Utils;
import com.k20411group03.adapters.ProductCollectionAdapter;
import com.k20411group03.home.databinding.ActivityProductCollectionBinding;
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

        //Custom action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        binding = ActivityProductCollectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.lvProductCollection);

        loadData();
        addEvents();
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
                Intent intentSearch = new Intent(ProductCollection.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(ProductCollection.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_menu:
                Intent intentMenu = new Intent(ProductCollection.this, MainMenu.class);
                startActivity(intentMenu);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addEvents() {
        binding.lvProductCollection.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductModel selectedProduct = listProduct.get(position);

                //INTENT ĐẾN MÀN HÌNH CHI TIẾT SẢN PHẨM

                intent = new Intent(ProductCollection.this, ProductDetails.class);
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("selectedProduct", (Serializable) selectedProduct);
                //intent.putExtras(bundle);
                intent.putExtra("ProductID", selectedProduct.getProductID());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }

    //===============LOAD DỮ LIỆU TỪ DATABASE VÀO LISTVIEW===============
    //NHẬN INTENT TỪ MÀN HÌNH SEARCH
    //NHẬN INTENT TỪ MÀN MAIN MENU
    //Intent screenTitle
    //Intent searchProductName

    private void loadData() {
        listProduct = new ArrayList<>();

        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);

        intent = getIntent();
        String screenTitle = intent.getStringExtra("screenTitle");

        //Query rỗng để tránh crash khi không nhận được intent
        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE 0 > 1", null);

        if(screenTitle != null){
            binding.txtTitle.setText(screenTitle.toUpperCase());
            //TH screenTitle là BỘ SƯU TẬP MỚI
            if(screenTitle.equals("Bộ sưu tập mới")){
                c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE(" + Utils.COL_CATEGORY + " = 'PL')",null);
            }
            //TH screenTitle là HÀNG MỚI VỀ
            else if(screenTitle.equals("Hàng mới về")){
                c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE(" + Utils.COL_ID + " IN (100, 101, 112, 113, 114, 121, 122, 131, 132, 200, 201, 210, 211, 219, 220, 229, 230))",null);
            }
            //TH screenTitle là SẢN PHẨM
            else if(screenTitle.equals("Sản phẩm")){
                c = db.query(Utils.TBL_NAME, null, null, null, null, null, null);;
            }
            else{
                binding.txtTitle.setText("SẢN PHẨM");
                Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
            }
        }
        //TH screenTitle = NULL
        else{
            //NHẬN INTENT TỪ MÀN HÌNH SEARCH
            String searchProductName = intent.getStringExtra("searchProductName");
            binding.txtTitle.setText("SẢN PHẨM");
            if(searchProductName != null){
                c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE UPPER(" + Utils.COL_NAME + ") LIKE '%" + searchProductName.toUpperCase() + "%'",null);
            }
            else{
                Toast.makeText(this, "Không có dữ liệu", Toast.LENGTH_SHORT).show();
            }
        }

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
        //Đóng database để giải phóng bộ nhớ
        c.close();
        binding.txtNumberOfProduct.setText(String.valueOf(c.getCount()) + " SẢN PHẨM");

        adapter = new ProductCollectionAdapter(ProductCollection.this, R.layout.item_list_product, listProduct);
        binding.lvProductCollection.setAdapter(adapter);
    }
}

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
import com.k20411group03.adapters.FlashsaleAdapter;
import com.k20411group03.home.databinding.ActivityFlashSaleScreenBinding;
import com.k20411group03.models.ProductModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class FlashSaleScreen extends AppCompatActivity {

    ActivityFlashSaleScreenBinding binding;
    FlashsaleAdapter adapter;
    ArrayList<ProductModel> flashsales;

    Intent intent;

    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

         //Custom action bar
         ActionBar actionBar = getSupportActionBar();
         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
         actionBar.setDisplayShowCustomEnabled(true);
         actionBar.setCustomView(R.layout.custom_action_bar);
         actionBar.setDisplayUseLogoEnabled(true);
         actionBar.setDisplayShowHomeEnabled(true);

        binding = ActivityFlashSaleScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //registerForContextMenu(binding.lvFlashsale);

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
                Intent intentSearch = new Intent(this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_BoSuuTap:
                Intent intentBoSuuTap = new Intent(this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "Bộ sưu tập mới");
                startActivity(intentBoSuuTap);
                break;
            case R.id.action_HangMoiVe:
                Intent intentSanPhamMoi = new Intent(this, ProductCollection.class);
                intentSanPhamMoi.putExtra("screenTitle", "Hàng mới về");
                startActivity(intentSanPhamMoi);
                break;
            case R.id.action_Flashsale:
                Intent intentFlashsale = new Intent(this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
                break;
            case R.id.action_SanPham:
                Intent intentSanPham = new Intent(this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "Sản phẩm");
                startActivity(intentSanPham);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadData() {
        flashsales = new ArrayList<>();

        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);

        //Cách 1: rawQuery ==> Truy vấn trực tiếp bằng câu lệnh sql

        //Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME, null);

//        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE "
//                + Utils.COL_ID + "=? OR " + Utils.COL_ID + "=?",
//                new String[]{"2", "4"});

        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE((" + Utils.COL_PRICE + "-" + Utils.COL_SALEPRICE + ")/" + Utils.COL_PRICE + ">0.25)",null);

        //Cách 2: query ==> Truy vấn bằng phương thức hỗ trợ

//        Cursor c = db.query(Utils.TBL_NAME, null, null,
//                null, null, null, null);

//        Cursor c = db.query(Utils.TBL_NAME,null, Utils.COL_PRICE + ">=?",new String[]{"16000"}, null, null, null);

        int ProductID;
        String ProductName;
        byte[] Thumbnail;
        double ProductPrice;
        double SalePrice;
        int Inventory;
        while (c.moveToNext()) {
            ProductID = c.getInt(0);
            ProductName = c.getString(1);
            Thumbnail = c.getBlob(3);
            ProductPrice = c.getDouble(4);
            SalePrice = c.getDouble(5);
            Inventory = c.getInt(7);

            flashsales.add(new ProductModel(ProductID, ProductName, null, Thumbnail, ProductPrice, SalePrice, null, Inventory));
        }

        //Đóng database để giải phóng bộ nhớ:
        c.close();

        adapter = new FlashsaleAdapter(this, R.layout.flash_sale_item, flashsales);
        binding.lvFlashsale.setAdapter(adapter);
    }

    private void addEvents() {
        binding.lvFlashsale.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductModel product = flashsales.get(position);
                intent = new Intent(FlashSaleScreen.this, ProductDetails.class);
                intent.putExtra("ProductID", product.getProductID());
                startActivity(intent);
            }
        });

        //nút back
        binding.imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume(){
        loadData();
        super.onResume();
    }
}

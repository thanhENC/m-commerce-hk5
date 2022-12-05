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

    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

//         //Custom action bar
//         ActionBar actionBar = getSupportActionBar();
//         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//         actionBar.setDisplayShowCustomEnabled(true);
//         actionBar.setCustomView(R.layout.custom_action_bar);
//         actionBar.setDisplayUseLogoEnabled(true);
//         actionBar.setDisplayShowHomeEnabled(true);

        binding = ActivityFlashSaleScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        registerForContextMenu(binding.lvFlashsale);

        copyDB();

        loadData();

    }

//     //Thêm action
//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {

//         getMenuInflater().inflate(R.menu.main, menu);
//         return super.onCreateOptionsMenu(menu);
//     }

//     //Sự kiện action bar
//     @Override
//     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//         switch (item.getItemId()) {
//             case R.id.action_search:
//                 Intent intentSearch = new Intent(FlashSaleScreen.this, ActivitySearch.class);
//                 startActivity(intentSearch);
//                 break;
//             case R.id.action_cart:
//                 Intent intentCart = new Intent(FlashSaleScreen.this, MainActivity.class);
//                 startActivity(intentCart);
//                 break;
//             case R.id.action_menu:
//                 Intent intentMenu = new Intent(FlashSaleScreen.this, MainMenu.class);
//                 startActivity(intentMenu);
//                 break;
//         }

//         return super.onOptionsItemSelected(item);
//     }

    //Khởi tạo và load data từ database:

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

    private void copyDB() {
        File dbPath = getDatabasePath(Utils.DB_NAME);
        if (!dbPath.exists()) {
            if (copyDBFromAssets()) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
            }
            ;
        }
    }

    private boolean copyDBFromAssets() {
        String dbPath = getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX + Utils.DB_NAME;
        try {
            InputStream inputStream = getAssets().open(Utils.DB_NAME);
            File f = new File(getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX);
            if (!f.exists()) {
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onResume(){
        loadData();
        super.onResume();
    }
}

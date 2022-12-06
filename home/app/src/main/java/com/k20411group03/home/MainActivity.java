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

import com.k20411group03.DisplayHelper;
import com.k20411group03.Utils;
import com.k20411group03.adapters.ProductInCartAdapter;
import com.k20411group03.home.databinding.ActivityMainBinding;
import com.k20411group03.models.Product;
import com.k20411group03.models.ProductInCartModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ProductInCartAdapter adapter;
    ArrayList<ProductInCartModel> products;

    SQLiteDatabase db;

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

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

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
                Intent intentSearch = new Intent(MainActivity.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_BoSuuTap:
                Intent intentBoSuuTap = new Intent(MainActivity.this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "Bộ sưu tập mới");
                startActivity(intentBoSuuTap);
                break;
            case R.id.action_HangMoiVe:
                Intent intentSanPhamMoi = new Intent(MainActivity.this, ProductCollection.class);
                intentSanPhamMoi.putExtra("screenTitle", "Hàng mới về");
                startActivity(intentSanPhamMoi);
                break;
            case R.id.action_Flashsale:
                Intent intentFlashsale = new Intent(MainActivity.this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
                break;
            case R.id.action_SanPham:
                Intent intentSanPham = new Intent(MainActivity.this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "Sản phẩm");
                startActivity(intentSanPham);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    private void loadData() {
        products = new ArrayList<>();

        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);

        //Giả sử ProductID [100, 101, 202] là sản phẩm trong giỏ hàng
        //Tạm thời query trong bảng Product để lấy thông tin sản phẩm nhưng thực chất phải query trong bảng Cart join với bảng Product
        //Chỉ lấy dữ liệu ở cột 0: ProductID, 1: ProductName, 2: ProductSalePrice, 3: ProductImage, 4: ProductQuantity
        Cursor c = db.rawQuery("SELECT " + Utils.COL_ID + ", " + Utils.COL_NAME + ", " + Utils.COL_SALEPRICE + ", " + Utils.COL_IMAGE + ", " + Utils.COL_INVENTORY + " FROM " + Utils.TBL_NAME + " WHERE " + Utils.COL_ID + " IN (100, 101, 202)", null);

        while (c.moveToNext()) {
            //Lấy dữ liệu từ database
            //Toàn bảng thực tế sẽ join 0: ProductID, 1: ProductName, 2: CategoryID, 3: Thumbnail, 4: Price, 5: SalePrice, 6: Description, 7: Quantity, 8: ProductSize, 9: ProductColor, 10: IsChecked

            int id = c.getInt(0);
            String name = c.getString(1);
            Double price = c.getDouble(2);
            byte[] image = c.getBlob(3);
            int quantity = c.getInt(4);

            //Tạo đối tượng ProductInCartModel
            //Giả sử size="S", color="Black"
            ProductInCartModel product = new ProductInCartModel(id, name, null, image, null, price, null, quantity, "S", "Black", false);
            products.add(product);
        }

        adapter = new ProductInCartAdapter(MainActivity.this, R.layout.cartitem, products);
        binding.lvGioHang.setAdapter(adapter);

//        binding.txtSum.setText(String.valueOf(DisplayHelper.formatPrice(adapter.sumOfAllProductsInCart())));
    }

    private void addEvents() {

        binding.txtThanhtoan.setText(String.valueOf(DisplayHelper.getValue(binding.txtSum.getText().toString()) -
                DisplayHelper.getValue(binding.txtGiatriCoupon.getText().toString())));

        binding.btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open gio hang
                Intent intent = new Intent(MainActivity.this, ThanhToanPre.class);
                intent.putExtra("GiatriCoupon", binding.txtGiatriCoupon.getText().toString());
                intent.putExtra("Thanhtoan", binding.txtThanhtoan.getText().toString());
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onResume() {
        loadData();
        super.onResume();
    }
}

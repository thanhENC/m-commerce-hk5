package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

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

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
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

        binding.txtTongTien.setText(String.valueOf(DisplayHelper.formatPrice(adapter.sumOfAllProductsInCart())));
    }

    private void addEvents() {

    }
}
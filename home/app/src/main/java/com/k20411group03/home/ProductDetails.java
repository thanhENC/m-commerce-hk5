package com.k20411group03.home;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.k20411group03.Utils;
import com.k20411group03.home.databinding.ActivityProductDetailsBinding;
import com.k20411group03.models.ProductModel;

public class ProductDetails extends AppCompatActivity {
    public static SQLiteDatabase db;
    ActivityProductDetailsBinding binding;
    int productID;
    int quantity;
    String size = "M";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void loadData(){

        //Nhận productID từ intent
        Intent intent = getIntent();
        productID = intent.getExtras().getInt("ProductID");
        //Lấy dữ liệu từ database
        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE(" + Utils.COL_ID + " = " + productID + ")",null);
        c.moveToFirst();
        String ProductName = c.getString(1);
        byte[] Thumbnail = c.getBlob(3);
        Double SalePrice = c.getDouble(5);
        String ProductDescription = c.getString(6);
        quantity = 1;

        //Đóng database để giải phóng bộ nhớ:
        db.close();

        //Hiển thị dữ liệu lên giao diện
        binding.txtProductsDetailName.setText(ProductName);
        binding.txtProductsDetailPrice.setText(SalePrice.toString());
        binding.txtProductsDetailDescription.setText(ProductDescription);
        binding.imvProductThumbDetail.setImageBitmap(convertByteArrayToBitmap(Thumbnail));
    }
    private Bitmap convertByteArrayToBitmap(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    private void addEvents(){
    binding.imvAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            quantity++;
            binding.txtProductsDetailQuantity.setText(quantity + "");
        }
    });
    binding.imvMinus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(quantity > 1){
                quantity--;
                binding.txtProductsDetailQuantity.setText(quantity + "");
            }
        }
    });
        //Thêm sản phẩm vào giỏ hàng
        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ProductDetails.this, MainActivity.class);
//                intent.putExtra("ProductID", productID);
//                intent.putExtra("Quantity", quantity);
//                intent.putExtra("Size", size);
//                startActivity(intent);
                //Hiển thị dialog thông báo
                Dialog dialog = new Dialog(ProductDetails.this);
                dialog.setContentView(R.layout.add_to_cart_dialog);

                Button btnContinueShopping = dialog.findViewById(R.id.btnContinueShopping);
            }
        });

        //Chọn size
        binding.radSizeL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = "L";
            }
        });
        binding.radSizeM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = "M";
            }
        });
        binding.radSizeXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = "XL";
            }
        });

        //Thêm sản phẩm vào yêu thích
        binding.imvAddWishList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Nạp dữ liệu vào database
                //Hiện thông báo đã thêm vào yêu thích
                Toast toast = Toast.makeText(getApplicationContext(), "Đã thêm vào danh sách yêu thích", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
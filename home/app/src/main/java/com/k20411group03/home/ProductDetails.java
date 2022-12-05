package com.k20411group03.home;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.k20411group03.DisplayHelper;
import com.k20411group03.Utils;
import com.k20411group03.home.databinding.ActivityProductDetailsBinding;
import com.k20411group03.models.ProductModel;

public class ProductDetails extends AppCompatActivity {
    public static SQLiteDatabase db;
    ActivityProductDetailsBinding binding;
    ProductModel product;
    int productID;
    int quantity;
    String size = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//         //Custom action bar
//         ActionBar actionBar = getSupportActionBar();
//         actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//         actionBar.setDisplayShowCustomEnabled(true);
//         actionBar.setCustomView(R.layout.custom_action_bar);
//         actionBar.setDisplayUseLogoEnabled(true);
//         actionBar.setDisplayShowHomeEnabled(true);
//         binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
//         setContentView(binding.getRoot());

        loadData();
        addEvents();
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
//                 Intent intentSearch = new Intent(ProductDetails.this, ActivitySearch.class);
//                 startActivity(intentSearch);
//                 break;
//             case R.id.action_cart:
//                 Intent intentCart = new Intent(ProductDetails.this, MainActivity.class);
//                 startActivity(intentCart);
//                 break;
//             case R.id.action_menu:
//                 Intent intentMenu = new Intent(ProductDetails.this, MainMenu.class);
//                 startActivity(intentMenu);
//                 break;
//         }

//         return super.onOptionsItemSelected(item);
//     }

    private void loadData(){

        //Nhận productID từ intent
        Intent intent = getIntent();
        productID = intent.getExtras().getInt("ProductID");
        //Lấy dữ liệu từ database
        db = openOrCreateDatabase(Utils.DB_NAME, MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM " + Utils.TBL_NAME + " WHERE(" + Utils.COL_ID + " = " + productID + ")",null);
        c.moveToFirst();

        //Đóng database để giải phóng bộ nhớ:
        db.close();

        product = new ProductModel(c.getInt(0), c.getString(1), null, c.getBlob(3), c.getDouble(4), c.getDouble(5), c.getString(6), 1);

        //Hiển thị dữ liệu lên giao diện
        binding.txtProductsDetailName.setText(product.getProductName());
        binding.txtProductsDetailPrice.setText(product.formatProductPrice(product.getProductSalePrice()));
        binding.txtProductsDetailDescription.setText(product.getProductDescription());
        binding.imvProductThumbDetail.setImageBitmap(product.getBitmapProductImage());
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
                //Lưu dữ liệu giỏ hàng vào database

                //Kiểm tra đơn hàng hợp lệ
                if (size.equals("")){
                    Toast.makeText(ProductDetails.this, "Vui lòng chọn size", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    //Lưu dữ liệu giỏ hàng vào database
                    //Hiển thị dialog thông báo đã thêm vào giỏ hàng
                    Dialog dialog = new Dialog(ProductDetails.this);
                    dialog.setContentView(R.layout.add_to_cart_dialog);
                    dialog.show();

                    Button btnContinueShopping = dialog.findViewById(R.id.btn_ContinueShopping);
                    Button btnGoToCart = dialog.findViewById(R.id.btn_GoToCart);
                    btnContinueShopping.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            //Intent intentHome = new Intent();
                            //intentHome.setClass(ProductDetails.this, ProductCollection.class);
                            //intentHome.putExtra("screenTitle", "Sản phẩm");
                            //startActivity(intentHome);
                        }
                    });
                    btnGoToCart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            Intent intentCart = new Intent();
                            intentCart.setClass(ProductDetails.this, MainActivity.class);
                            startActivity(intentCart);
                        }
                    });
                }

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

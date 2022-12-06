package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
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
import android.widget.Toast;

import com.k20411group03.CustomerData;
import com.k20411group03.DisplayHelper;
import com.k20411group03.adapters.PaymentItemAdapter;
import com.k20411group03.home.databinding.ActivityThanhToanPreBinding;
import com.k20411group03.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ThanhToanPre extends AppCompatActivity {

    ActivityThanhToanPreBinding binding;
    PaymentItemAdapter adapter;
    List<Product> products;
    Intent intent, intent1, intent2;

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

        intent = getIntent();

        binding.txtSurname.setText(intent.getStringExtra("Ho"));
        binding.txtFirstname.setText(intent.getStringExtra("Ten"));
        binding.txtPhone.setText(intent.getStringExtra("Phone"));
        binding.txtStreet.setText(intent.getStringExtra("Street"));
        binding.txtAddress.setText(intent.getStringExtra("Address"));

        intent1 = getIntent();

        binding.txtPaymentMethod.setText(intent1.getStringExtra("Phuongthucthanhtoan"));
        binding.imvPaymentImage.setImageResource(intent1.getIntExtra("Image",R.drawable.payment_cash));

        intent2 = getIntent();

        binding.txtMaCoupon.setText(intent2.getStringExtra("GiatriCoupon"));
        binding.txtPhiVanChuyen.setText("30000đ");
        binding.txtTongTien.setText(String.valueOf(DisplayHelper.getValue(intent.getStringExtra("Thanhtoan")) +  30000));

    }

    private void addEvents() {

        binding.txtUseDefaultInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Open Dia Chi Nhan Hang
                intent = getIntent();

                binding.txtSurname.setText(CustomerData.info.FIRST_NAME);
                binding.txtFirstname.setText(CustomerData.info.LAST_NAME);
                binding.txtPhone.setText(CustomerData.info.PHONE);
                binding.txtStreet.setText(CustomerData.address.HOUSE_NUMBER + ", " + CustomerData.address.STREET);
                binding.txtAddress.setText(CustomerData.address.WARD + ", " + CustomerData.address.DISTRICT +
                        ", " + CustomerData.address.CITY);

            }
        });

        binding.ChangePayment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //Open Phuong thuc thanh toan
                Intent intent = new Intent (ThanhToanPre.this, ThanhToan.class);
                startActivity(intent);
            }
        });

        binding.ChangeDiachinhanhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open gio hang
                Intent intent = new Intent(ThanhToanPre.this, DiaChiNhanHang.class);
                intent.putExtra("Ho1", binding.txtSurname.getText().toString());
                intent.putExtra("Ten1", binding.txtFirstname.getText().toString());
                intent.putExtra("Phone1", binding.txtPhone.getText().toString());
                intent.putExtra("Street1", binding.txtStreet.getText().toString());
                
                startActivity(intent);
                //ActivityResultLauncher<Intent> laucher = null;
                //laucher.launch(intent);
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
            case R.id.action_BoSuuTap:
                Intent intentBoSuuTap = new Intent(ThanhToanPre.this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "Bộ sưu tập mới");
                startActivity(intentBoSuuTap);
                break;
            case R.id.action_HangMoiVe:
                Intent intentSanPhamMoi = new Intent(ThanhToanPre.this, ProductCollection.class);
                intentSanPhamMoi.putExtra("screenTitle", "Hàng mới về");
                startActivity(intentSanPhamMoi);
                break;
            case R.id.action_Flashsale:
                Intent intentFlashsale = new Intent(ThanhToanPre.this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
                break;
            case R.id.action_SanPham:
                Intent intentSanPham = new Intent(ThanhToanPre.this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "Sản phẩm");
                startActivity(intentSanPham);
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

    @Override
    protected void onResume() {
        loadData();
        getData();
        addEvents();
        super.onResume();
    }
}

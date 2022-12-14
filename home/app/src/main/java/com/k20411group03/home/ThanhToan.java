package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.k20411group03.DatabaseHelper;
import com.k20411group03.adapters.PaymentAdapter;
import com.k20411group03.home.databinding.ActivityThanhToanBinding;
import com.k20411group03.models.Payment;

import java.util.ArrayList;
import java.util.List;

public class ThanhToan extends AppCompatActivity {

    ActivityThanhToanBinding binding;
    PaymentAdapter adapter;
    List<Payment> payments;
    DatabaseHelper db;

    //ActivityResultLauncher<Intent> launcher;

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

        binding = ActivityThanhToanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        createDb();
        loadData();
        addEvents();
    }

    private void createDb() {
        db = new DatabaseHelper(ThanhToan.this);
        db.createSampleData();
    }

    private void loadData() {
        payments = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME);
        while (c.moveToNext()){
            payments.add(new Payment(c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getInt(3)
            ));
        }
        c.close();

        //Init data
        //binding.lvPhuongThucThanhToan.setChoiceMode(binding.lvPhuongThucThanhToan.CHOICE_MODE_SINGLE);
        adapter = new PaymentAdapter(ThanhToan.this, R.layout.payment_method, payments);
        binding.lvPhuongThucThanhToan.setAdapter(adapter);
    }

    //Th??m action
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //S??? ki???n action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent intentSearch = new Intent(ThanhToan.this, ActivitySearch.class);
                startActivity(intentSearch);
                break;
            case R.id.action_cart:
                Intent intentCart = new Intent(ThanhToan.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_BoSuuTap:
                Intent intentBoSuuTap = new Intent(ThanhToan.this, ProductCollection.class);
                intentBoSuuTap.putExtra("screenTitle", "B??? s??u t???p m???i");
                startActivity(intentBoSuuTap);
                break;
            case R.id.action_HangMoiVe:
                Intent intentSanPhamMoi = new Intent(ThanhToan.this, ProductCollection.class);
                intentSanPhamMoi.putExtra("screenTitle", "H??ng m???i v???");
                startActivity(intentSanPhamMoi);
                break;
            case R.id.action_Flashsale:
                Intent intentFlashsale = new Intent(ThanhToan.this, FlashSaleScreen.class);
                startActivity(intentFlashsale);
                break;
            case R.id.action_SanPham:
                Intent intentSanPham = new Intent(ThanhToan.this, ProductCollection.class);
                intentSanPham.putExtra("screenTitle", "S???n ph???m");
                startActivity(intentSanPham);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void addEvents() {
//        binding.btnConfirmpayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Open gio hang
//                Intent intent = new Intent(ThanhToan.this, MainActivity.class);
//                intent.putExtra("Payment", "Momo");
//
//                startActivity(intent);
//                //????? d??? li???u ???????c g???i ??i v?? tr??? v???
//                //Cach 1: S??? d???ng startActivityForResult
//                //                startActivityForResult(intent,REQUEST_CODE);
//
//                //Cach 2: S??? d???ng ActivityResultLauncher
//                launcher.launch(intent);
//            }
//        });

        binding.imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // When clicking on the item, the dialog will appear
        binding.lvPhuongThucThanhToan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Get product info
                Payment p = (Payment) adapter.getItem(i);
                Intent intent1 = new Intent(ThanhToan.this, ThanhToanPre.class);
                intent1.putExtra("Phuongthucthanhtoan", p.getPaymentName());
                intent1.putExtra("Image", p.getPaymentImage());
                startActivity(intent1);
                //ActivityResultLauncher<Intent> launcher = null;
                //launcher.launch(intent1);

            }
        });
    }
}
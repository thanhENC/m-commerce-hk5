package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.k20411group03.adapters.PaymentAdapter;
import com.k20411group03.adapters.ProductAdapter;
import com.k20411group03.home.databinding.ActivityMainBinding;
import com.k20411group03.home.databinding.ActivityThanhToanBinding;
import com.k20411group03.models.Payment;
import com.k20411group03.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ThanhToan extends AppCompatActivity {

    ActivityThanhToanBinding binding;
    PaymentAdapter adapter;
    List<Payment> payments;
    DatabaseHelper db;
    private String False;
    //ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

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
                    c.getInt(3),
                    c.getExtras().getBoolean(String.valueOf(false))
            ));
        }
        c.close();

        //Init data
        adapter = new PaymentAdapter(ThanhToan.this, R.layout.payment_method, payments);
        binding.lvPhuongThucThanhToan.setAdapter(adapter);

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
//                //Để dữ liệu được gửi đi và trả về
//                //Cach 1: Sử dụng startActivityForResult
//                //                startActivityForResult(intent,REQUEST_CODE);
//
//                //Cach 2: Sử dụng ActivityResultLauncher
//                launcher.launch(intent);
//            }
//        });
    }
}

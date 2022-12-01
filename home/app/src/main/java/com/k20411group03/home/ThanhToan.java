package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    //ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityThanhToanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        addEvents();
    }

    private void loadData() {
        payments = new ArrayList<>();

        payments.add(new Payment(false, R.drawable.payment_cash, "Thanh toán tiền mặt", "Thanh toán khi nhận hàng"));
        payments.add(new Payment(false, R.drawable.payment_momo, "Ví Momo", ""));

        payments.add(new Payment(false, R.drawable.payment_zalo, "Ví ZaloPay", ""));

        payments.add(new Payment(false, R.drawable.payment_banking, "Thẻ ATM/ Internet Banking", "Hỗ trợ hơn 20 ngân hàng"));

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

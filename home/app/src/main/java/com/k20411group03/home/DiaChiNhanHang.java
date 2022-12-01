package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.k20411group03.home.databinding.ActivityDiaChiNhanHangBinding;

public class DiaChiNhanHang extends AppCompatActivity {

    ActivityDiaChiNhanHangBinding binding;
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi_nhan_hang);

        binding = ActivityDiaChiNhanHangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
    }

    private void addEvents() {
//        binding.btnConfirmaddress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Open gio hang
//                Intent intent = new Intent(DiaChiNhanHang.this, MainActivity.class);
//                intent.putExtra("Ho", binding.edtSurname.getText().toString());
//                intent.putExtra("Ten", binding.edtFirstname.getText().toString());
//                intent.putExtra("Phone", binding.edtPhone.getText().toString());
//                intent.putExtra("Street", binding.edtStreet.getText().toString());
//                intent.putExtra("Ward", binding.edtWard.getText().toString());
//                intent.putExtra("District", binding.edtDistrict.getText().toString());
//                intent.putExtra("Province", binding.edtProvince.getText().toString());
//                intent.putExtra("Note", binding.edtNoteaddress.getText().toString());
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
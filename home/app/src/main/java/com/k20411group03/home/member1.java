package com.k20411group03.home;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.k20411group03.home.databinding.ActivityMember1Binding;
import com.k20411group03.home.databinding.ActivityVoucherMainBinding;

public class member1 extends AppCompatActivity {
    ActivityMember1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_member1);
        binding= ActivityMember1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(member1.this);
                dialog.setContentView(R.layout.dialog_dangxuat);
                dialog.setCanceledOnTouchOutside(false);
                TextView txtDangXuat = dialog.findViewById(R.id.txtYes);
                txtDangXuat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(member1.this, TrangChu.class);
                        startActivity(intent);
                    }
                });
                TextView txtHuy = dialog.findViewById(R.id.txtQuit);
                txtHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }


}
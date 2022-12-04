package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.k20411group03.home.databinding.ActivitySearchBinding;

public class ActivitySearch extends AppCompatActivity {

    ActivitySearchBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addEvents();
    }

    private void addEvents() {
        binding.imvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ActivitySearch.this, ProductCollection.class);
                intent.putExtra("searchProductName", binding.edtSearch.getText().toString());
                startActivity(intent);
            }
        });
        binding.imvEmptySearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.edtSearch.setText("");
            }
        });
        searchTerm(binding.txtAoThunRelax);
        searchTerm(binding.txtQuanDai);
        searchTerm(binding.txtAoSoMi);
        searchTerm(binding.txtAoKhoacNam);
        searchTerm(binding.txtQuanShorts);
        searchTerm(binding.txtAoThun);
        searchTerm(binding.txtQuanJogger);
        searchTerm(binding.txtAoPolo);
    }

    private void searchTerm(TextView txtSearchTerm){
        txtSearchTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(ActivitySearch.this, ProductCollection.class);
                intent.putExtra("searchProductName", txtSearchTerm.getText().toString());
                startActivity(intent);
            }
        });
    }
}
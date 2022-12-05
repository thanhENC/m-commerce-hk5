package com.k20411group03.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

        //Custom action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        addEvents();
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
            case R.id.action_cart:
                Intent intentCart = new Intent(ActivitySearch.this, MainActivity.class);
                startActivity(intentCart);
                break;
            case R.id.action_menu:
                Intent intentMenu = new Intent(ActivitySearch.this, MainMenu.class);
                startActivity(intentMenu);
                break;
        }

        return super.onOptionsItemSelected(item);
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
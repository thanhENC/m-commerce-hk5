package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.k20411group03.adapters.BosuutapmoiAdapter;
import com.k20411group03.home.databinding.ActivityNewCollectionBinding;
import com.k20411group03.models.Bosuutapmoi;
import com.k20411group03.models.Hangmoive;

import java.util.ArrayList;

public class NewCollection extends AppCompatActivity {

    ActivityNewCollectionBinding binding;
    BosuutapmoiAdapter adapter;
    ArrayList<Bosuutapmoi> listBosuutapmoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //     setContentView(R.layout.activity_new_collection);
        binding = ActivityNewCollectionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {

        listBosuutapmoi = new ArrayList<>();
        listBosuutapmoi.add(new Bosuutapmoi("San Pham 1 ", 10000000, R.drawable.nen));
        listBosuutapmoi.add(new Bosuutapmoi("San Pham 1 ", 10000000, R.drawable.nen));
        listBosuutapmoi.add(new Bosuutapmoi("San Pham 1 ", 10000000, R.drawable.nen));
        listBosuutapmoi.add(new Bosuutapmoi("San Pham 1 ", 10000000, R.drawable.nen));
        adapter = new BosuutapmoiAdapter(NewCollection.this , R.layout.item_list_bosuutapmoi, listBosuutapmoi);
        binding.lvBosuutapmoi.setAdapter(adapter);
    }
}
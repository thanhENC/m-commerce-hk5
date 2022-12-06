package com.k20411group03.home;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.k20411group03.Utils;
import com.k20411group03.home.databinding.ActivityHomescreenBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class homescreen extends AppCompatActivity {
    ActivityHomescreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        binding = ActivityHomescreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();
        copyDB();
    }

    private void addEvents() {
        binding.btnKhamPha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opening activity 2
                Intent intent = new Intent(homescreen.this,homescreen2.class);
                startActivity(intent);
            }
        });
    }

    private void copyDB() {
        File dbPath = getDatabasePath(Utils.DB_NAME);
        if (!dbPath.exists()) {
            if (copyDBFromAssets()) {
                Toast.makeText(this, "Chào mừng bạn đã đến\n với 🌟 THE WEEKDAYS 🌟!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Tải dữ liệu không thành công!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean copyDBFromAssets() {
        String dbPath = getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX + Utils.DB_NAME;
        try {
            InputStream inputStream = getAssets().open(Utils.DB_NAME);
            File f = new File(getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX);
            if (!f.exists()) {
                f.mkdir();
            }
            OutputStream outputStream = new FileOutputStream(dbPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}

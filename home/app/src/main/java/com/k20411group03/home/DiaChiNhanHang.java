package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.k20411group03.Utils;
import com.k20411group03.home.databinding.ActivityDiaChiNhanHangBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class DiaChiNhanHang extends Activity {

    ActivityDiaChiNhanHangBinding binding;
    ActivityResultLauncher<Intent> launcher;
    ArrayAdapter<String> adapter, adapter1, adapter2;
    Intent intent;

    private Spinner spinnerprovince, spinnerdistrict, spinnerward;
    TextView txtprovince, txtdistrict, txtWard;
    EditText edtSurname, edtFirstname, edtPhone, edtStreet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_chi_nhan_hang);

//        //Custom action bar
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setCustomView(R.layout.custom_action_bar);
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);

        binding = ActivityDiaChiNhanHangBinding.inflate(getLayoutInflater());

        ArrayList<String> provincesArr = new ArrayList<>();
        txtprovince = binding.txtProvince;
        spinnerprovince = binding.spinnerProvince;

        ArrayList<String> districtArr = new ArrayList<>();
        txtdistrict = binding.txtDistrict;
        spinnerdistrict = binding.spinnerDistrict;

        ArrayList<String> wardArr = new ArrayList<>();
        txtWard = binding.txtWard;
        spinnerward = binding.spinnerWard;


        setContentView(binding.getRoot());
        addEvents();
//        loadData();

        copyDB();
        getData();

        SQLiteDatabase db = openOrCreateDatabase(Utils.DB_LC_NAME, MODE_PRIVATE, null);

        Cursor c = db.query(Utils.TBL_LC_PROVINCE, null, null,
                null, null, null, null);

        String province_name;
        while (c.moveToNext()) {
            province_name = c.getString(1);
            provincesArr.add(province_name);
        }

//        //Đóng database để giải phóng bộ nhớ:

        c.close();

        String[] provinces = provincesArr.toArray(new String[provincesArr.size()]);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, provinces);

        adapter.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        spinnerprovince.setAdapter(adapter);
//        spinnerprovince.setOnItemSelectedListener(new MyProcessEvent());
        spinnerprovince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

//            Khi có chọn lựa thì vào hàm này
            public void onItemSelected(AdapterView<?> arg0,
                                   View arg1,
                                   int arg2,
                                   long arg3) {
            //arg2 là phần tử được chọn trong data source
                txtprovince.setText(provinces[arg2]);

//                Cursor c1 = db.query(Utils.TBL_LC_DISTRICT, null, Utils.COL_LC_DISTRICT_PROVINCE_ID + " = (SELECT " +  Utils.COL_LC_PROVINCE_ID + " FROM " + Utils.TBL_LC_PROVINCE + " WHERE "
//                        + Utils.COL_LC_PROVINCE_NAME + " = ?) ",    new String []{provincess}         , null, null, null);
//                String district_name;
//
////                Cursor c2 = db.query(Utils.TBL_LC_DISTRICT, null, Utils.COL_LC_DISTRICT_PROVINCE_ID + " = ?",    province_ids, null, null, null);
////                String district_name;
//
//                while (c1.moveToNext()) {
//                    district_name = c1.getString(1);
//                    districtArr.add(district_name);
//                }
//                c1.close();

            }

        //Nếu không chọn gì cả
            public void onNothingSelected(AdapterView<?> arg0) {
            txtprovince.setText("");
            }

        });

        Cursor c1 = db.query(Utils.TBL_LC_DISTRICT, null, null,
                null, null, null, null);

        String district_name;
        while (c1.moveToNext()) {
            district_name = c1.getString(1);
            districtArr.add(district_name);
        }

//        //Đóng database để giải phóng bộ nhớ:

        c1.close();

        String[] districts = districtArr.toArray(new String[districtArr.size()]);

        adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, districts);

        adapter1.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        spinnerdistrict.setAdapter(adapter1);
//        spinnerprovince.setOnItemSelectedListener(new MyProcessEvent());
        spinnerdistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //            Khi có chọn lựa thì vào hàm này
            public void onItemSelected(AdapterView<?> arg0,
                                       View arg1,
                                       int arg2,
                                       long arg3) {
                //arg2 là phần tử được chọn trong data source
                txtdistrict.setText(districts[arg2]);

            }

            //Nếu không chọn gì cả
            public void onNothingSelected(AdapterView<?> arg0) {
                txtdistrict.setText("");
            }

        });

        Cursor c2 = db.query(Utils.TBL_LC_WARD, null, null,
                null, null, null, null);

        String ward_name;
        while (c2.moveToNext()) {
            ward_name = c2.getString(1);
            wardArr.add(ward_name);
        }

//        //Đóng database để giải phóng bộ nhớ:

        c2.close();

        String[] wards = wardArr.toArray(new String[wardArr.size()]);

        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, wards);

        adapter2.setDropDownViewResource(layout.simple_spinner_dropdown_item);

        spinnerward.setAdapter(adapter2);
//        spinnerprovince.setOnItemSelectedListener(new MyProcessEvent());
        spinnerward.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //            Khi có chọn lựa thì vào hàm này
            public void onItemSelected(AdapterView<?> arg0,
                                       View arg1,
                                       int arg2,
                                       long arg3) {
                //arg2 là phần tử được chọn trong data source
                txtWard.setText(wards[arg2]);

            }

            //Nếu không chọn gì cả
            public void onNothingSelected(AdapterView<?> arg0) {
                txtWard.setText("");
            }

        });

    }

    private void getData() {
        intent = getIntent();
        binding.edtSurname.setText(intent.getStringExtra("Ho1"));
        binding.edtFirstname.setText(intent.getStringExtra("Ten1"));
        binding.edtPhone.setText(intent.getStringExtra("Phone1"));
        binding.edtStreet.setText(intent.getStringExtra("Street1"));
    }


    private void copyDB() {
        File dbPath = getDatabasePath(Utils.DB_LC_NAME);
        if (!dbPath.exists()) {
            if (copyDBFromAssets()) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
            }
            ;
        }
    }

    private boolean copyDBFromAssets() {
        String dbPath = getApplicationInfo().dataDir + Utils.DB_PATH_SUFFIX + Utils.DB_LC_NAME;
        try {
            InputStream inputStream = getAssets().open(Utils.DB_LC_NAME);
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


//     //Thêm action
//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {

//         getMenuInflater().inflate(R.menu.main, menu);
//         return super.onCreateOptionsMenu(menu);
//     }

//     //Sự kiện action bar
//     @Override
//     public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//         switch (item.getItemId()) {
//             case R.id.action_search:
//                 Intent intentSearch = new Intent(DiaChiNhanHang.this, ActivitySearch.class);
//                 startActivity(intentSearch);
//                 break;
//             case R.id.action_cart:
//                 Intent intentCart = new Intent(DiaChiNhanHang.this, MainActivity.class);
//                 startActivity(intentCart);
//                 break;
//             case R.id.action_menu:
//                 Intent intentMenu = new Intent(DiaChiNhanHang.this, MainMenu.class);
//                 startActivity(intentMenu);
//                 break;
//         }

//         return super.onOptionsItemSelected(item);
//     }

    private void addEvents() {

        binding.btnConfirmaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Open gio hang
                Intent intent = new Intent(DiaChiNhanHang.this, ThanhToanPre.class);
                intent.putExtra("Ho", binding.edtSurname.getText().toString());
                intent.putExtra("Ten", binding.edtFirstname.getText().toString());
                intent.putExtra("Phone", binding.edtPhone.getText().toString());
                intent.putExtra("Street", binding.edtStreet.getText().toString());
                intent.putExtra("Address", binding.txtWard.getText().toString()
                + ", " + binding.txtDistrict.getText().toString() + ", " + binding.txtProvince.getText().toString());

                startActivity(intent);
                launcher.launch(intent);
            }
        });

    }

//    @Override
//    protected void onResume(){
//        loadData();
//        super.onResume();
//    }
}

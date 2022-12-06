package com.k20411group03.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;
import com.k20411group03.Utilities.Constants;
import com.k20411group03.Utilities.PreferenceManager;
import com.k20411group03.Utils;
import com.k20411group03.home.databinding.ActivityDangKyBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class DangKy extends AppCompatActivity {

    private ActivityDangKyBinding binding;
    private PreferenceManager preferenceManager;
    private String encodedImage;
    ActivityResultLauncher<Intent> launcher;
    ArrayAdapter<String> adapter, adapter1, adapter2;

    private Spinner spinnerprovince, spinnerdistrict, spinnerward;
    TextView txtprovince, txtdistrict, txtWard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDangKyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager= new PreferenceManager(getApplicationContext());
// array list
        ArrayList<String> provincesArr = new ArrayList<>();
        txtprovince = binding.txtProvince;
        spinnerprovince = binding.spinnerProvince;

        ArrayList<String> districtArr = new ArrayList<>();
        txtdistrict = binding.txtDistrict;
        spinnerdistrict = binding.spinnerDistrict;

        ArrayList<String> wardArr = new ArrayList<>();
        txtWard = binding.txtWard;
        spinnerward = binding.spinnerWard;
        // get data from database
        copyDB();
        setListeners();
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

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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


//        binding.textSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Open activity 2
//                Intent intent = new Intent(DangKy.this, dangnhap1.class);
//                startActivity(intent);
//            }
//        });


    private void copyDB() {
        File dbPath = getDatabasePath(Utils.DB_LC_NAME);
        if (!dbPath.exists()) {
            if (copyDBFromAssets()) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Fail!", Toast.LENGTH_SHORT).show();
            }
        }
    }

//    private void addEvents() {
//        binding.btnConfirmaddress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Open gio hang
//                Intent intent = new Intent(DangKy.this, DangKy.class);
//                intent.putExtra("Ho", binding.edtSurname.getText().toString());
//                intent.putExtra("Ten", binding.edtFirstname.getText().toString());
//                intent.putExtra("Phone", binding.edtPhone.getText().toString());
//                intent.putExtra("Street", binding.edtStreet.getText().toString());
//                intent.putExtra("Address", binding.txtWard.getText().toString()
//                        + ", " + binding.txtDistrict.getText().toString() + ", " + binding.txtProvince.getText().toString());
//
//                startActivity(intent);
//                launcher.launch(intent);
//                // save data to database
//                saveData();
//            }
//        });
//    }

    private void saveData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        HashMap<String, Object> user = new HashMap<>();
        user.put(Constants.KEY_NAME, binding.inputName.getText().toString());
        user.put(Constants.KEY_EMAIL, binding.inputEmail.getText().toString());
        user.put(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString());
        user.put(Constants.KEY_PHONE, binding.inputPhone.getText().toString());
        user.put(Constants.KEY_HO, binding.edtSurname.getText().toString());
        user.put(Constants.KEY_TEN, binding.edtFirstname.getText().toString());
        user.put(Constants.KEY_TINH, binding.txtProvince.getText().toString());
        user.put(Constants.KEY_QUAN, binding.txtDistrict.getText().toString());
        user.put(Constants.KEY_PHUONG, binding.txtWard.getText().toString());
        user.put(Constants.KEY_DIACHI, binding. edtStreet.getText().toString());
        db.collection(Constants.KEY_COLLECTION_USERS)
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    //Save user id to shared preferences
                    preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                    preferenceManager.putString(Constants.KEY_USER_ID, documentReference.getId());
                    preferenceManager.putString(Constants.KEY_NAME, binding.inputName.getText().toString());
                    preferenceManager.putString(Constants.KEY_EMAIL, binding.inputEmail.getText().toString());
                    preferenceManager.putString(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString());
                    preferenceManager.putString(Constants.KEY_PHONE, binding.inputPhone.getText().toString());
                    preferenceManager.putString(Constants.KEY_HO, binding.edtSurname.getText().toString());
                    preferenceManager.putString(Constants.KEY_TEN, binding.edtFirstname.getText().toString());
                    preferenceManager.putString(Constants.KEY_TINH, binding.txtProvince.getText().toString());
                    preferenceManager.putString(Constants.KEY_QUAN, binding.txtDistrict.getText().toString());
                    preferenceManager.putString(Constants.KEY_PHUONG, binding.txtWard.getText().toString());
                    preferenceManager.putString(Constants.KEY_DIACHI, binding. edtStreet.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), dangnhap1.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    Toast.makeText(DangKy.this, "Đã lưu thông tin thành công", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                })

                .addOnFailureListener(e -> {
                    Toast.makeText(DangKy.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
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

    private void setListeners() {
        binding.textSignIn.setOnClickListener(v -> startActivity(new Intent(DangKy.this, dangnhap1.class)));
        binding.buttonSignUp.setOnClickListener(v -> {
            if (isValidSignUpDetails()) {
                //Upload data to the database
                signUp();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void signUp(){
        loading(true);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        HashMap<String, Object> user = new HashMap<>();
        user.put(Constants.KEY_NAME, binding.inputName.getText().toString());
        user.put(Constants.KEY_EMAIL, binding.inputEmail.getText().toString());
        user.put(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString());
        user.put(Constants.KEY_PHONE, binding.inputPhone.getText().toString());
        db.collection(Constants.KEY_COLLECTION_USERS)
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    //Save user id to shared preferences
                    loading(false);
                    preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                    preferenceManager.putString(Constants.KEY_USER_ID, documentReference.getId());
                    preferenceManager.putString(Constants.KEY_NAME, binding.inputName.getText().toString());
                    Intent intent = new Intent(getApplicationContext(), dangnhap1.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                })
                .addOnFailureListener(e -> {
                    loading(false);
                    Toast.makeText(DangKy.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
        saveData();
    }



    private Boolean isValidSignUpDetails() {
        if (binding.inputName.getText().toString().trim().isEmpty()) {
            showToast("Please enter your name");
            return false;
        } else if (binding.inputEmail.getText().toString().trim().isEmpty()) {
            showToast("Please enter your email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString().trim()).matches()) {
            showToast("Please enter a valid email");
            return false;
        }else if (binding.inputPhone.getText().toString().trim().isEmpty()) {
            showToast("Please enter your phone number");
            return false;
        } else if (binding.inputPhone.getText().toString().trim().length() < 10) {
            showToast("Please enter a valid phone number");
            return false;
        } else if (binding.inputPassword.getText().toString().trim().isEmpty()) {
            return false;
        } else if (binding.inputPassword.getText().toString().trim().length() < 6) {
            showToast("Password must be at least 6 characters");
            return false;
        } else if (binding.inputConfirmPassword.getText().toString().trim().isEmpty()) {
            showToast("Please confirm your password");
            return false;
        } else if (!binding.inputPassword.getText().toString().trim().equals(binding.inputConfirmPassword.getText().toString().trim())) {
            showToast("Passwords do not match");
            return false;
        }else if(binding.txtProvince.getText().toString().trim().isEmpty()){
            showToast("Please enter your province");
            return false;
        }else if(binding.txtDistrict.getText().toString().trim().isEmpty()){
            showToast("Please enter your district");
            return false;
        }else if(binding.txtWard.getText().toString().trim().isEmpty()){
            showToast("Please enter your ward");
            return false;
        }else if(binding.edtStreet.getText().toString().trim().isEmpty()){
            showToast("Please enter your street");
            return false;
        } else {
            return true;
        }

    }
    private void loading(Boolean isLoading) {
        if (isLoading) {
            binding.buttonSignUp.setVisibility(View.GONE);
            binding.progressBar.setVisibility(View.VISIBLE);
        } else {
            binding.buttonSignUp.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.GONE);
        }
    }

}


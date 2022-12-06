package com.k20411group03.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.k20411group03.Utilities.Constants;
import com.k20411group03.Utilities.PreferenceManager;
import com.k20411group03.home.databinding.ActivityDangKyBinding;
import com.k20411group03.home.databinding.ActivityDangnhap1Binding;

import java.util.HashMap;

public class dangnhap1 extends AppCompatActivity {
    private ActivityDangnhap1Binding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceManager= new PreferenceManager(getApplicationContext());
        //màn hình đăng nhập: nếu ng dùng đã đăng nhập thành công, thì dù out khỏi app vẫn lưu lại đc thông tin và không bị sign out
//        if(preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN)){
//            Intent intent = new Intent(getApplicationContext(),TrangChu.class); // chuyển qua trang chủ ?
//            startActivity(intent);
//            finish();
//        }
        binding = ActivityDangnhap1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();


    }

    private void setListeners() {
        binding.textCreateNewAccount.setOnClickListener(v -> startActivity(new Intent(dangnhap1.this, DangKy.class)));
        binding.buttonSignIn.setOnClickListener(v -> {
            if(isValidSignInDatails()){
                signIn();
            }
        });
        //test mesage truyen vao
    }
    //test user ID co duoc nhan vao cloud khong
//    private void addDataToFirestore(){
//        FirebaseFirestore database = FirebaseFirestore.getInstance();
//        HashMap<String, Object> data = new HashMap<>();
//        data.put("first_name", "Chrag");
//        data.put("last_name", "Chrag");
//        database.collection("users").add(data)
//                .addOnSuccessListener(documentReference -> {
//                    // Document has been saved successfully
//                    Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
//                })
//                .addOnFailureListener(exception -> {
//                    // Error while saving document
//                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
//                });
//    }

    private void signIn(){
        loading(true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
                .whereEqualTo(Constants.KEY_EMAIL, binding.inputEmail.getText().toString())
                .whereEqualTo(Constants.KEY_PASSWORD, binding.inputPassword.getText().toString())
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0){
                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
                        preferenceManager.putString(Constants.KEY_USER_ID, task.getResult().getDocuments().get(0).getId());
                        preferenceManager.putString(Constants.KEY_EMAIL, task.getResult().getDocuments().get(0).getString(Constants.KEY_EMAIL));
                        Toast.makeText(dangnhap1.this, "Đăng nhập tài khoản thành công!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), member1.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }else{
                        loading(false);
                        Toast.makeText(dangnhap1.this, "Lỗi đăng nhập, chưa thành công!", Toast.LENGTH_SHORT).show();
                    }
                });


    }
    private void loading(Boolean isLoading){
        if(isLoading){
            binding.buttonSignIn.setVisibility(View.INVISIBLE);
            binding.progressBar.setVisibility(View.VISIBLE);
        }else{
            binding.buttonSignIn.setVisibility(View.VISIBLE);
            binding.progressBar.setVisibility(View.INVISIBLE);
        }
    }
    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    private  Boolean isValidSignInDatails(){
        if (binding.inputEmail.getText().toString().isEmpty()){
            showToast("Please enter email");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()){
            showToast("Enter valid email");
            return false;
        } else if(
            binding.inputPassword.getText().toString().isEmpty()){
                showToast("Please enter password");
                return false;
            }else{
                return true;
            }
        }
    }
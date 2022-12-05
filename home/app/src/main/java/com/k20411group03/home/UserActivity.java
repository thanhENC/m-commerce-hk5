package com.k20411group03.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.k20411group03.Utilities.Constants;
import com.k20411group03.Utilities.PreferenceManager;
import com.k20411group03.adapters.UsersAdapter;
import com.k20411group03.home.databinding.ActivityUserBinding;
import com.k20411group03.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {
    private ActivityUserBinding binding;
    private PreferenceManager preferenceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        preferenceManager = new PreferenceManager(getApplicationContext());
//        setListeners();
        getUsers();
    }

//    private void setListeners() {
//        binding.imageBack.setOnClickListener(v -> onBackPressed());
//    }

private void getUsers() {
        loading( true);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection(Constants.KEY_COLLECTION_USERS)
            .get()
            .addOnCompleteListener(task -> {
                loading(false);
                String currentUserId = preferenceManager.getString(Constants.KEY_USER_ID);
                if (task.isSuccessful() && task.getResult() != null) {
                    List<User> users = new ArrayList<>();
                    for (QueryDocumentSnapshot queryDocumentSnapshot : task.getResult()) {
                        if (currentUserId.equals(queryDocumentSnapshot.getId())) {
                            continue;
                        }
                        User user = new User();
                        user.name = queryDocumentSnapshot.getString(Constants.KEY_NAME);
                        user.email = queryDocumentSnapshot.getString(Constants.KEY_EMAIL);
                        //user.image = DocumentSnapshot.getString(Constants.KEY_IMAGE);
                        user.token = queryDocumentSnapshot.getString(Constants.KEY_FCM_TOKEN);
                        users.add(user);
                        }
                            if (users.size() > 0) {
                                UsersAdapter usersAdapter= new UsersAdapter(users);
                                binding.userRecyclerView.setAdapter(usersAdapter);
                                binding.userRecyclerView.setVisibility(View.VISIBLE);
                            //binding.userRecyclerView.setAdapter(new UsersAdapter(users, this));
                            }
                            else {
                                showErrorMessage();
                                }
                }else{
                    showErrorMessage();
                     }
            });
}

        private void showErrorMessage() {
            binding.textErrorMessage.setText(String.format("%s", "No user available"));
            binding.textErrorMessage.setVisibility(View.VISIBLE);
        }


        private void loading(Boolean isLoading) {
            if (isLoading) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
            binding.progressBar.setVisibility(View.INVISIBLE);
            }
    }
}
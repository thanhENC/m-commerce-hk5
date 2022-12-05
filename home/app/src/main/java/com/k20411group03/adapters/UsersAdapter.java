package com.k20411group03.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.k20411group03.home.databinding.ItenContainerUserBinding;
import com.k20411group03.listener.UserListener;
import com.k20411group03.models.User;

import java.util.List;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private final List<User> users;
    ItenContainerUserBinding ItenContainerUserBinding;

    public UsersAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItenContainerUserBinding itenContainerUserBinding = ItenContainerUserBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new UserViewHolder(itenContainerUserBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
            ItenContainerUserBinding binding;

        UserViewHolder(ItenContainerUserBinding itenContainerUserBinding) {
            super(itenContainerUserBinding.getRoot());
            binding = itenContainerUserBinding;
        }
    void setUserData(User user) {
       binding.textName.setText(user.name);
       binding.textEmail.setText(user.email);
       //binding.imageProfile.setImageBitmap(getUserImage(user.getImage()));binding.getRoot().setOnClickListener(v -> userListener.onUserClick(user));
        }
//    private Bitmap getUserImage(String encodedImage){
//        byte[] bytes = Base64.decode(encodedImage, Base64.DEFAULT);
//        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
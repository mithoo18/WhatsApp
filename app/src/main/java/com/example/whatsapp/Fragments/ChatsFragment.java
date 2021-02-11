package com.example.whatsapp.Fragments;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.example.whatsapp.Model.Users;
import com.example.whatsapp.R;
import com.example.whatsapp.UsersAdapter;
import com.example.whatsapp.databinding.FragmentChatsBinding;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class ChatsFragment extends Fragment {

    public ChatsFragment() {
    }

    FragmentChatsBinding binding;
    ArrayList<Users> list = new ArrayList<>();
    FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //DATABASE
        database = FirebaseDatabase.getInstance();
        //INFLATE -> BINDING
        binding = FragmentChatsBinding.inflate(inflater,container,false);

        //ADAPTER -> USE
        UsersAdapter adapter = new UsersAdapter(list,getContext());

        binding.chatRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.chatRecyclerView.setLayoutManager(layoutManager);

        //DATA -> GET(FIREBASE)
        database.getReference().child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //USE SNAPSHOT
                list.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Users users = dataSnapshot.getValue(Users.class);
                    users.getUserId(dataSnapshot.getKey());
                    list.add(users);

                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return binding.getRoot();
    }
}
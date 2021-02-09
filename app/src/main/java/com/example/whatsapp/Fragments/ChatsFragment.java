package com.example.whatsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;

import com.example.whatsapp.Model.Users;
import com.example.whatsapp.R;
import com.example.whatsapp.UsersAdapter;
import com.example.whatsapp.databinding.FragmentChatsBinding;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.firebase.database.FirebaseDatabase;

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
        // Inflate the layout for this fragment
        binding = FragmentChatsBinding.inflate(inflater,container,false);
        return binding.getRoot();

        //ADAPTER
        //PROBLEM-----
        UsersAdapter adapter = new UsersAdapter(list,getContext());

        //LAYOUT
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        //PROBLEM-----
        binding.chatRecyclerView.setLayoutManager(adapter);
    }
}
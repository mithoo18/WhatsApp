package com.example.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.whatsapp.Adapter.FragmentAdapter;
import com.example.whatsapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //FIREBASE
        auth = FirebaseAuth.getInstance();
        //BIND VIEWPAGER TABLAYOUT
        /*Tab Layout
              View Pager(USING Adapter)
                    Fragment */
        binding.viewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewpager);

    }

    //MENU BIND (INFLATE)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //MENU DECISION
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
         case R.id.settings:
             Toast.makeText(MainActivity.this, "Setting Page Is Going TO Opem", Toast.LENGTH_SHORT).show();
             break;

         case R.id.logout:
             auth.signOut();
             FirebaseAuth.getInstance().signOut();
             Intent intent = new Intent(MainActivity.this, SignIn.class);
             startActivity(intent);
             break;
        }
        return true;
        // return super.onOptionsItemSelected(item);
    }
}
package com.autotech.MyApp.pages;
import com.autotech.MyApp.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.autotech.MyApp.pages.SettingsActivity;
import com.autotech.MyApp.pages.ChatActivity;
import com.autotech.MyApp.pages.StudioActivity;
import com.autotech.MyApp.users.User;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button b_Chat = findViewById(R.id.Chat);
        b_Chat.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ChatActivity.class);
            startActivity(intent);
        });

        Button b_Profilo = findViewById(R.id.Profilo);
        b_Profilo.setOnClickListener(v -> {
           User u = (User) getIntent().getSerializableExtra("User");
           Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
           intent.putExtra("User", u);
           startActivity(intent);
        });
        
        Button b_Studio = findViewById(R.id.Studio);
        b_Studio.setOnClickListener(v -> {
           User u = (User) getIntent().getSerializableExtra("User");
           Intent intent = new Intent(HomeActivity.this, StudioActivity.class);
           intent.putExtra("User", u);
           startActivity(intent);
        });

    }
}

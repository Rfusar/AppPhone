package com.autotech.MyApp.pages;
import com.autotech.MyApp.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autotech.MyApp.users.User;


import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    private User currentUser;
    
    private LinearLayout Friends_container;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        
        currentUser = (User) getIntent().getSerializableExtra("User");

        Friends_container = findViewById(R.id.Friends);

        for(String i : currentUser.getFriends()){addRow(i);}

    }

    private void addRow(String text){
        LayoutInflater inflater = LayoutInflater.from(this);
        View rowView = inflater.inflate(R.layout.row_chat, null);

        TextView textView = rowView.findViewById(R.id.Row);
        textView.setText(text);
        Friends_container.addView(rowView);
    }
}

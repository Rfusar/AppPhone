package com.autotech.MyApp.pages;
import com.autotech.MyApp.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    
    private LinearLayout Friends_container;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Friends_container = findViewById(R.id.Friends);

        String[] items = {
            "Riccardo Fusaro",
            "Lorenzo Apa",
            "Manuel Sgura"
        };
        for(String i : items){addRow(i);}

    }

    private void addRow(String text){
        LayoutInflater inflater = LayoutInflater.from(this);
        View rowView = inflater.inflate(R.layout.row_chat, null);

        TextView textView = rowView.findViewById(R.id.Row);
        textView.setText(text);
        Friends_container.addView(rowView);
    }
}

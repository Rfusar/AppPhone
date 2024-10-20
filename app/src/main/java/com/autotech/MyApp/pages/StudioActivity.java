package com.autotech.MyApp.pages;

import com.autotech.MyApp.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.autotech.MyApp.users.User;
import com.autotech.MyApp.utils.Request;

public class StudioActivity extends AppCompatActivity {
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio);
        
        currentUser = (User) getIntent().getSerializableExtra("User");

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        Click(btn1, currentUser.getAPI());
        Click(btn2, currentUser.getAPI()+"/home");
        Click(btn3, currentUser.getAPI()+"/sendMessage");
    }


    public void Click(Button b, String url){
        b.setOnClickListener(v-> { 
            new Request(this).execute(url);
        });
    }
}

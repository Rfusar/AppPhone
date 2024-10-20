package com.autotech.MyApp;
import com.autotech.MyApp.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.autotech.MyApp.pages.HomeActivity;

public class MainActivity extends AppCompatActivity {
    private String username_value;
    private String password_value;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView img = findViewById(R.id.img);
        img.setImageResource(R.drawable.icon_app);
        
        EditText username = findViewById(R.id.Username);
        EditText password = findViewById(R.id.Password);
        Button btn = findViewById(R.id.sendLogin);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                username_value = username.getText().toString().trim();
                password_value = password.getText().toString().trim();

                if(username_value.isEmpty() || password_value.isEmpty()){
                    Toast.makeText(MainActivity.this, "Devi inserire username e password coglione", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(username_value.equals("riccardo") && password_value.equals("admin")){
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class); 
                        startActivity(intent);
                    }
                }
            }
        });


    }
}

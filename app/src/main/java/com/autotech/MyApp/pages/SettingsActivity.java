package com.autotech.MyApp.pages;
import com.autotech.MyApp.R;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.autotech.MyApp.users.User;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private User currentUser;
    private TextView span_0;
    private TextView span_1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        
        span_0 = findViewById(R.id.setting_username);
        span_0.setText("Username: "+currentUser.getUsername());

        span_1 = findViewById(R.id.setting_friends);

        StringBuilder friends_str = new StringBuilder();
        for(String f : currentUser.getFriends()){
            friends_str.append(f).append(", ");
        }
        span_1.setText("friends: "+friends_str.toString());


        Switch is_private = findViewById(R.id.privato);
        is_private.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                Toast.makeText(this, "Ora sei privato", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Ora non sei privato", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

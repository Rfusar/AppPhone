package com.autotech.MyApp.pages;
import com.autotech.MyApp.R;

import android.os.Bundle;
import android.content.DialogInterface;
import android.app.NotificationManager;
import android.content.Intent;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

import com.autotech.MyApp.users.User;
import com.autotech.MyApp.utils.Notifica;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

public class SettingsActivity extends AppCompatActivity {
    private User currentUser;
    private TextView span_api;
    private TextView span_0;
    private TextView span_1;
    private Switch is_private;
    private Switch is_notif;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        currentUser = (User) getIntent().getSerializableExtra("User");
        
        //set private
        is_private = findViewById(R.id.privato);
        is_private.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                Toast.makeText(this, "Ora sei privato", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Ora non sei privato", Toast.LENGTH_SHORT).show();
            }
        });
        //set notif
        is_notif = findViewById(R.id.setting_notif);
        is_notif.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Notifica nm = Notifica.getInstance(this);
            if(isChecked){
                nm.startRepeatingAlarm();
                currentUser.setIsNotif(true);
                Toast.makeText(this, "Notifiche Attive", Toast.LENGTH_SHORT).show();
            }
            else{
                nm.stopAlarm();
                currentUser.setIsNotif(false);
                Toast.makeText(this, "Notifiche disattivate", Toast.LENGTH_SHORT).show();
            }
        });

        //View API User
        span_api = findViewById(R.id.setting_api);
        span_api.setText("API:  "+currentUser.getAPI());

        //View Name User
        span_0 = findViewById(R.id.setting_username);
        span_0.setText("Username: "+currentUser.getUsername());

        //View Friends User
        span_1 = findViewById(R.id.setting_friends);
        StringBuilder friends_str = new StringBuilder();
        for(String f : currentUser.getFriends()){
            friends_str.append(f).append(", ");
        }
        span_1.setText("friends: "+friends_str.toString());

        Button modifyAPI = findViewById(R.id.ModifyAPI);
        modifyAPI.setOnClickListener(v-> showModifyAPI());
    }


    private void showModifyAPI(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modifica API");

        final EditText input = new EditText(this);
        input.setText(currentUser.getAPI());
        builder.setView(input);

        builder.setPositiveButton("Conferma", (dialog, which) -> {
            String new_api = input.getText().toString();
            currentUser.setAPI(new_api);
            span_api.setText("API: "+new_api);
        });
        builder.setNegativeButton("Annulla", (dialog, which) -> dialog.cancel());
        builder.show();

    }
}

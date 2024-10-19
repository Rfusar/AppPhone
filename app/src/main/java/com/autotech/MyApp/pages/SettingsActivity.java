package com.autotech.MyApp.pages;
import com.autotech.MyApp.R;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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

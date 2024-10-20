package com.autotech.MyApp.users;

import com.autotech.MyApp.users.User;
import android.widget.Toast;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class DB {
    private User[] users;

    public DB(){
        this.users = new User[]{
            new User("Riccardo", "admin", 
                new String[]{
                    "Lorenzo Apa", "Manuel Sgura", "Tommaso Punta"
                }
            )
        };
    }
    public User[] init(){return this.users;}

    public static void saveData(Context c){
        File dir_backup = new File(c.getFilesDir(), "Database_appRicky");
        if(!dir_backup.exists()){
            dir_backup.mkdir();
        }
        
        File file = new File(dir_backup, "Backup.json");
        try(FileOutputStream fos = new FileOutputStream(file)){
            fos.write("{\"profilo\":\"Riccardo Fusaro\"}".getBytes());
            fos.flush();
            Toast.makeText(c, "Backup eseguito con successo", Toast.LENGTH_SHORT).show();
        }
        catch(IOException e){
            Toast.makeText(c, "Backup non eseguito", Toast.LENGTH_SHORT).show();
        }
    }
}

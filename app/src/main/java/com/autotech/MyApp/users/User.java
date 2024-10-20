package com.autotech.MyApp.users;

import java.io.Serializable;
import com.autotech.MyApp.users.DB;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean is_admin;
    private Boolean is_active;
    private Boolean is_notif;
    private String API;
    private String username;
    private String password;
    private String[] friends;

    public User(String username, String password, String[] friends){
        if(username==null||password==null||friends==null){
            throw new IllegalArgumentException("Username, Password, Frieds valori nulli nella 'intalizzazione della class User");
        }
        this.username = username;
        this.password = password;
        this.friends = friends;
        this.is_active = false;
        this.is_notif = false;
        if(username.equals("Riccardo") && password.equals("admin")){ this.is_admin = true; }
        else{this.is_admin=false;}
        this.API = "http://192.168.1.162:8000";

    }
    //username
    public String getUsername(){return this.username.toString();}
    
    //friends
    public String[] getFriends(){return this.friends;}

    //active
    public void setActive(Boolean b){this.is_active = b;}
    public Boolean getIsActive(){return this.is_active;}

    //notif
    public void setIsNotif(Boolean b){this.is_notif = b;}
    public Boolean getIsNotif(){return this.is_notif;}

    //api
    public void setAPI(String new_api){this.API = new_api;}
    public String getAPI(){return this.API;}


    //Methods
    public static User login(String username, String password){
        User[] database = new DB().init();
        for (User u : database){
            if(username.equals(u.username) && password.equals(u.password)){
                return new User(u.username, "", u.friends);
            }
        }
        return null;
    }

}

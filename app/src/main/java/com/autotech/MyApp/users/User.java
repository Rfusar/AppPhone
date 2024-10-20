package com.autotech.MyApp.users;

import com.autotech.MyApp.users.DB;

public class User {
    private String username;
    private String password;
    private String[] friends;
    private Boolean is_active;
    
    public User(String username, String password, String[] friends){
        this.username = username;
        this.password = password;
        this.friends = friends;
    }
    public String getUsername(){return this.username.toString();}
    public String[] getFriends(){return this.friends;}

    public void active(Boolean b){this.is_active=b;}

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

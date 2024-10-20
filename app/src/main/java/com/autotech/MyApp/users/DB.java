package com.autotech.MyApp.users;

import com.autotech.MyApp.users.User;

public class DB {
    private User[] users;

    public DB(){
        this.users = new User[]{
            new User("Riccardo", "admin", new String[]{"Lorenzo Apa", "Manuel Sgura"})
        };
    }
    public User[] init(){return this.users;}
}

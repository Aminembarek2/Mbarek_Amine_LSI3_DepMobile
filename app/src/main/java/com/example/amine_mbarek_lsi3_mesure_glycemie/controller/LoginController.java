package com.example.amine_mbarek_lsi3_mesure_glycemie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.amine_mbarek_lsi3_mesure_glycemie.model.User;

public class LoginController {
    private static final String PREF_NAME = "user_pref";
    private static final String USER_NAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";

    private static LoginController instance;
    private User user;

    private LoginController() {
        // Private constructor for Singleton pattern
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }

    public void createUser(String userName, String password, Context context) {
        user = new User(userName, password);

        // Save user credentials to SharedPreferences
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME_KEY, userName);
        editor.putString(PASSWORD_KEY, password);
        editor.apply();
    }

    public static void recapUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString(USER_NAME_KEY, "");
        String password = sharedPreferences.getString(PASSWORD_KEY, "");

        if (!userName.isEmpty() && !password.isEmpty()) {
            instance.user = new User(userName, password);
        }
    }

    public User getUser() {
        return user;
    }
}

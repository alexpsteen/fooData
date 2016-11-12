package com.example.alexsteen.foodata;

import android.os.AsyncTask;

/**
 * Created by Alex Steen on 11/12/2016.
 */

public class Login extends AsyncTask<String, String, String> {
    String errMsg = "";
    boolean isSuccessful = false;
    String user;
    String password;

    public Login(String userName, String pass) {
        user = userName;
        password = pass;
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    }
}


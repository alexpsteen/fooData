package com.example.alexsteen.foodata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;

    private Button loginBtn;
    private Button registerBtn;

    private ConnectionClass connectionClass;
    private ProgressBar progressBar;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        usernameField = (EditText) findViewById(R.id.username);
        passwordField = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        cb = (CheckBox) findViewById(R.id.checkMark);

        connectionClass = new ConnectionClass();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        cb.setVisibility(View.GONE);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Login login = new Login(usernameField.getText().toString(), passwordField.getText().toString());
//                login.execute();
                progressBar.setVisibility(View.VISIBLE);
                Intent i = new Intent(MainActivity.this, Welcome.class);
                progressBar.setVisibility(View.GONE);
                cb.setVisibility(View.VISIBLE);
                try {
                    Thread.sleep(1000, 0);
                } catch (InterruptedException e) {
                    //do anything?
                }
                cb.setVisibility(View.GONE);
                startActivity(i);
                finish();

            }
        });

    }

    public class Login extends AsyncTask<String, String, String> {
        String msg = "";
        boolean isSuccessful = false;
        String user;
        String password;

        public Login(String userName, String pass) {
            user = userName;
            password = pass;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();

            if (isSuccessful) {
                Intent i = new Intent(MainActivity.this, Welcome.class);
                progressBar.setVisibility(View.GONE);
                cb.setVisibility(View.VISIBLE);
                try {
                    Thread.sleep(1000, 0);
                } catch (InterruptedException e) {
                    //do anything?
                }
                cb.setVisibility(View.GONE);
                startActivity(i);
                finish();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            if (user.trim().equals("")) {
                msg = "Please enter a username";
            } else if (password.trim().equals("")) {
                msg = "Please enter a password";
            } else {
                try {
                    Connection connect = connectionClass.connect();
                    if (connect == null) {
                        msg = "Error in connection with SSMS";
                    } else {
                        String query = "SELECT * FROM Usertbl WHERE UserID='" + user
                                + "' AND Password='" + password + "'";
                        Statement statement = connect.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);
                        if (resultSet.next()){
                            msg = "Login Sucessful";
                            isSuccessful = true;
                        } else {
                            isSuccessful = false;
                            msg = "Invalid Username or Password";
                        }
                    }
                } catch (SQLException e) {
                    isSuccessful = false;
                    msg = "Something went wrong...";
                }

            }
            return msg;
        }
    }

    /**
     * Created by Alex Steen on 11/12/2016.
     */

    public class ConnectionClass {
        String ip = "128.61.73.140";
        String class_ = "net.sourceforge.jtds.jdbc.Driver";
        String db = "Android";
        String un = "ALEX-LAPTOP\\Alex Steen";
        String password = "Jesuslives1220";

        @SuppressLint("NewApi")
        public Connection connect() {
            System.out.println("lol((((((((((((((((((((((((((((");
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection connection = null;
            String connectionURL = null;

            try {
                Class.forName(class_);
                connectionURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName="
                        + db + ";user=" + un + ";password=" + password + ";";
                connection = DriverManager.getConnection(connectionURL);
            } catch (SQLException e) {
//            Log.e("ERROR", e.getMessage());
            } catch (ClassNotFoundException e) {
//            Log.e("ERROR", e.getMessage());
                System.out.println("CLASS^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            } catch (Exception e) {
//            Log.e("ERROR", e.getMessage());
            }

            return connection;
        }
    }


}


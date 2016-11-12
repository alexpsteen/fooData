package com.example.alexsteen.foodata;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;

    private Button loginBtn;
    private Button registerBtn;

//    private FirebaseAuth fbAuth;
//    private FirebaseAuth.AuthStateListener fbAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText) findViewById(R.id.username);
        passwordField = (EditText) findViewById(R.id.password);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);

//        fbAuth = FirebaseAuth.getInstance();
//        fbAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                if (fbAuth.getCurrentUser() != null) {
//                    //TODO: Start next page intent
//                }
//            }
//        }


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
    }

    private void signIn() {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();


        if (TextUtils.isEmpty(username)) {
            Toast.makeText(MainActivity.this, "Please enter username", Toast.LENGTH_LONG).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_LONG).show();
        } else {
//            fbAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if (!task.isSuccessful()) {
//                        Toast.makeText(MainActivity.this, "Unable to sign-in", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
        }
    }

}

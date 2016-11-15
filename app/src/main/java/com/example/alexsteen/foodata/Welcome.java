package com.example.alexsteen.foodata;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMsg);
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour > 18 || hour < 2) {
            welcomeMessage.setText("Good evening,");
        } else if (hour > 11) {
            welcomeMessage.setText("Good afternoon,");
        } else {
            welcomeMessage.setText("Good morning,");
        }

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_welcome);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextScreen();
            }
        });
    }

    protected void nextScreen() {
        Intent i = new Intent(Welcome.this, Home.class);
        startActivity(i);
        finish();
//        this.overridePendingTransition(0,0);
    }
}

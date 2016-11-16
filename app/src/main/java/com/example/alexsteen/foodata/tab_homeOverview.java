package com.example.alexsteen.foodata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alex Steen on 11/15/2016.
 */

public class tab_homeOverview extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.tab_homeoverview, container, false);

        //Overview
        TextView today = (TextView) rootView.findViewById(R.id.date);


        Date day = new Date();
        SimpleDateFormat sDate = new SimpleDateFormat("MMMM dd, yyyy");
        today.setText(sDate.format(day));


        return rootView;
    }
}

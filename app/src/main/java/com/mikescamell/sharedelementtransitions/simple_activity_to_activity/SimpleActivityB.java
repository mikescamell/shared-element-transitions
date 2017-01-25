package com.mikescamell.sharedelementtransitions.simple_activity_to_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mikescamell.sharedelementtransitions.R;

public class SimpleActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }
}

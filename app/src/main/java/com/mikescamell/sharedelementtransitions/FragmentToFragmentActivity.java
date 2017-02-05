package com.mikescamell.sharedelementtransitions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mikescamell.sharedelementtransitions.simple_fragment_to_fragment.SimpleFragmentA;

public class FragmentToFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, new SimpleFragmentA())
                .commit();
    }
}
package com.mikescamell.sharedelementtransitions.glide_fragment_to_fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mikescamell.sharedelementtransitions.R;

public class GlideFragmentToFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_to_fragment);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content, GlideFragmentA.newInstance())
                    .commit();
        }
    }
}
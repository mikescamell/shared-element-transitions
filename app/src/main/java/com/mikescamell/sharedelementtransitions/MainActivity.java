package com.mikescamell.sharedelementtransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mikescamell.sharedelementtransitions.picasso_activity_to_activity.PicassoActivityA;
import com.mikescamell.sharedelementtransitions.picasso_fragment_to_fragment.PicassoFragmentToFragmentActivity;
import com.mikescamell.sharedelementtransitions.simple_activity_to_activity.SimpleActivityA;
import com.mikescamell.sharedelementtransitions.simple_fragment_to_fragment.FragmentToFragmentActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityToActivityBtn = (Button) findViewById(R.id.activity_to_activity_btn);
        activityToActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SimpleActivityA.class));
            }
        });

        Button fragmentToFragmentBtn = (Button) findViewById(R.id.fragment_to_fragment_btn);
        fragmentToFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FragmentToFragmentActivity.class));
            }
        });

        Button picassoActivityBtn = (Button) findViewById(R.id.picasso_activity_to_activity_btn);
        picassoActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PicassoActivityA.class));
            }
        });

        Button picassoFragmentBtn = (Button) findViewById(R.id.picasso_fragment_to_fragment_btn);
        picassoFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PicassoFragmentToFragmentActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        getSupportFragmentManager().popBackStack();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        }
    }
}

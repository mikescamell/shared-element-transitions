package com.mikescamell.sharedelementtransitions.simple_activity_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;

public class SimpleActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        final ImageView imageView = findViewById(R.id.simple_activity_a_imageView);

        Button button = findViewById(R.id.simple_activity_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivityA.this, SimpleActivityB.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        SimpleActivityA.this,
                        imageView,
                        ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });

    }
}

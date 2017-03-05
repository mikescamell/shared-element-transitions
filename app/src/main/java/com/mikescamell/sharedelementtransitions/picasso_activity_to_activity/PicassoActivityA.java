package com.mikescamell.sharedelementtransitions.picasso_activity_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;
import com.squareup.picasso.Picasso;

public class PicassoActivityA extends AppCompatActivity {

    public static final String TIGER_PIC_URL = "https://cdn.pixabay.com/photo/2016/11/29/10/07/animal-1868911_1280.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picasso_activity_a);

        final ImageView imageView = (ImageView) findViewById(R.id.picasso_activity_a_imageView);
        Picasso.with(this)
                .load(TIGER_PIC_URL)
                .fit()
                .centerCrop()
                .into(imageView);

        Button button = (Button) findViewById(R.id.picasso_activity_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PicassoActivityA.this, PicassoActivityB.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(PicassoActivityA.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });

    }
}

package com.mikescamell.sharedelementtransitions.glide_activity_to_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mikescamell.sharedelementtransitions.R;

public class GlideActivityA extends AppCompatActivity {

    public static final String FOX_PIC_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Red_Fox_(Vulpes_vulpes)_(4).jpg/640px-Red_Fox_(Vulpes_vulpes)_(4).jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glide_activity_a);

        final ImageView imageView = (ImageView) findViewById(R.id.glide_activity_a_imageView);
        Glide.with(this)
                .load(FOX_PIC_URL)
                .centerCrop()
                .into(imageView);

        Button button = (Button) findViewById(R.id.glide_activity_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GlideActivityA.this, GlideActivityB.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(GlideActivityA.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });

    }
}

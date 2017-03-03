package com.mikescamell.sharedelementtransitions.flash_fix.programmatic_activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mikescamell.sharedelementtransitions.R;

public class FlashFixProgrammaticActivityA extends AppCompatActivity {

    public static final String STARFISH_IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/f/f2/Starfish_09_(paulshaffner).jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_fix_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade();
            fade.excludeTarget(R.id.appBar, true);
            fade.excludeTarget(android.R.id.statusBarBackground, true);
            fade.excludeTarget(android.R.id.navigationBarBackground, true);

            getWindow().setEnterTransition(fade);
            getWindow().setExitTransition(fade);
        }

        final ImageView imageView = (ImageView) findViewById(R.id.flash_fix_xml_activity_a_imageView);
        Glide.with(this)
                .load(STARFISH_IMAGE_URL)
                .centerCrop()
                .into(imageView);

        Button button = (Button) findViewById(R.id.flash_fix_xml_activity_a_btn);
        button.setText(R.string.starfish);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashFixProgrammaticActivityA.this, FlashFixProgrammaticActivityB.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(FlashFixProgrammaticActivityA.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });
    }
}

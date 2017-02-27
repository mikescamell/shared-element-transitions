package com.mikescamell.sharedelementtransitions.flash_fix.programmatic_activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.mikescamell.sharedelementtransitions.R;

public class FlashFixProgrammaticActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_fix_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        supportPostponeEnterTransition();

        TextView detailTextView = (TextView) findViewById(R.id.flash_fix_activity_b_text);
        detailTextView.setText(getString(R.string.starfish_blurb));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Fade fade = new Fade();
            fade.excludeTarget(R.id.appBar, true);
            fade.excludeTarget(android.R.id.statusBarBackground, true);
            fade.excludeTarget(android.R.id.navigationBarBackground, true);
            getWindow().setEnterTransition(fade);
            getWindow().setExitTransition(fade);
        }

        ImageView imageView = (ImageView) findViewById(R.id.flash_fix_activity_b_imageView);

        Glide.with(this)
                .load(FlashFixProgrammaticActivityA.STARFISH_IMAGE_URL)
                .centerCrop()
                .dontAnimate()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }
                })
                .into(imageView);
    }
}
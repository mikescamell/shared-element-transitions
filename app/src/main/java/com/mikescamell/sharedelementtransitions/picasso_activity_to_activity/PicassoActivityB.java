package com.mikescamell.sharedelementtransitions.picasso_activity_to_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picasso_activity_b);
        ImageView imageView = (ImageView) findViewById(R.id.picasso_activity_b_image);

        supportPostponeEnterTransition();

        Picasso.with(this)
                .load(PicassoActivityA.TIGER_PIC_URL)
                .fit()
                .noFade()
                .centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                        supportStartPostponedEnterTransition();
                    }
                });
    }
}
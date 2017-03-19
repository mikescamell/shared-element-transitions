package com.mikescamell.sharedelementtransitions.flash_fix.xml_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mikescamell.sharedelementtransitions.R;

public class FlashFixXmlActivityA extends AppCompatActivity {

    public static final String PIG_PIC_URL = "http://s0.geograph.org.uk/photos/57/76/577604_d3efbef6.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_fix_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageView imageView = (ImageView) findViewById(R.id.flash_fix_xml_activity_a_imageView);
        Glide.with(this)
                .load(PIG_PIC_URL)
                .centerCrop()
                .into(imageView);

        Button button = (Button) findViewById(R.id.flash_fix_xml_activity_a_btn);
        button.setText(R.string.pig);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FlashFixXmlActivityA.this, FlashFixXmlActivityB.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(FlashFixXmlActivityA.this,
                                imageView,
                                ViewCompat.getTransitionName(imageView));
                startActivity(intent, options.toBundle());
            }
        });

    }
}

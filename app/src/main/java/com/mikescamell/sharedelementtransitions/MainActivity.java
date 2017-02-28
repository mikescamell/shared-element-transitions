package com.mikescamell.sharedelementtransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mikescamell.sharedelementtransitions.flash_fix.programmatic_activity.FlashFixProgrammaticActivityA;
import com.mikescamell.sharedelementtransitions.flash_fix.xml_activity.FlashFixXmlActivityA;
import com.mikescamell.sharedelementtransitions.glide_activity_to_activity.GlideActivityA;
import com.mikescamell.sharedelementtransitions.glide_fragment_to_fragment.GlideFragmentToFragmentActivity;
import com.mikescamell.sharedelementtransitions.picasso_activity_to_activity.PicassoActivityA;
import com.mikescamell.sharedelementtransitions.picasso_fragment_to_fragment.PicassoFragmentToFragmentActivity;
import com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_fragment.RecyclerViewToFragmentActivity;
import com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_viewpager.RecyclerViewToViewPagerActivity;
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

        Button glideActivityBtn = (Button) findViewById(R.id.glide_activity_to_activity_btn);
        glideActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GlideActivityA.class));
            }
        });

        Button glideFragmentBtn = (Button) findViewById(R.id.glide_fragment_to_fragment_btn);
        glideFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GlideFragmentToFragmentActivity.class));
            }
        });

        Button recyclerViewToAcitivtyBtn = (Button) findViewById(R.id.recycler_view_to_activity_btn);
        recyclerViewToAcitivtyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_activity.RecyclerViewActivity.class));
            }
        });

        Button recyclerViewToFragmentBtn = (Button) findViewById(R.id.recycler_view_to_fragment_btn);
        recyclerViewToFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewToFragmentActivity.class));
            }
        });

        Button recyclerViewToViewPagerBtn = (Button) findViewById(R.id.recycler_view_to_view_pager_btn);
        recyclerViewToViewPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewToViewPagerActivity.class));
            }
        });

        Button programmaticFlashFixActivity = (Button) findViewById(R.id.flash_fix_programmatic_activity_btn);
        programmaticFlashFixActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FlashFixProgrammaticActivityA.class));
            }
        });

        Button xmlFlashFixActivity = (Button) findViewById(R.id.flash_fix_xml_activity_btn);
        xmlFlashFixActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FlashFixXmlActivityA.class));
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

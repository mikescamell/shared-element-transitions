package com.mikescamell.sharedelementtransitions.flash_fix.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mikescamell.sharedelementtransitions.R;

public class FlashFixFragmentA extends Fragment {

    public static final String TAG = FlashFixFragmentA.class.getSimpleName();
    public static String OWL_PIC_URL = "https://upload.wikimedia.org/wikipedia/commons/8/8f/Bubo_bubo_-British_Wildlife_Centre,_Surrey,_England-8a.jpg";

    public FlashFixFragmentA() {
        // Required empty public constructor
    }

    public static FlashFixFragmentA newInstance() {
        return new FlashFixFragmentA();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        postponeEnterTransition();
        return inflater.inflate(R.layout.fragment_flash_fix_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView imageView = (ImageView) view.findViewById(R.id.fragment_flash_fix_a_imageView);

        Glide.with(getContext())
                .load(OWL_PIC_URL)
                .centerCrop()
                .into(imageView);

        Button button = (Button) view.findViewById(R.id.fragment_flash_fix_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlashFixFragmentB simpleFragmentB = FlashFixFragmentB.newInstance();
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView, getString(R.string.simple_fragment_transition))
                        .addToBackStack(TAG)
                        .replace(R.id.content, simpleFragmentB)
                        .commit();
            }
        });
    }
}
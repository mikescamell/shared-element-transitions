package com.mikescamell.sharedelementtransitions.glide_fragment_to_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mikescamell.sharedelementtransitions.R;

public class GlideFragmentA extends Fragment {

    public static final String TAG = GlideFragmentA.class.getSimpleName();
    public static String ARMADILLO_PIC_URL = "http://a1.img.talkingpointsmemo.com/image/upload/c_fill,fl_keep_iptc,g_faces,h_365,w_652/xiglrkmrizdvmkdqw50j.jpg";

    public GlideFragmentA() {
        // Required empty public constructor
    }

    public static GlideFragmentA newInstance() {
        return new GlideFragmentA();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.glide_fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView imageView = (ImageView) view.findViewById(R.id.glide_fragment_a_imageView);
        Glide.with(getContext())
                .load(ARMADILLO_PIC_URL)
                .centerCrop()
                .into(imageView);

        Button button = (Button) view.findViewById(R.id.glide_fragment_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlideFragmentB simpleFragmentB = GlideFragmentB.newInstance();
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView, ViewCompat.getTransitionName(imageView))
                        .addToBackStack(TAG)
                        .replace(R.id.content, simpleFragmentB)
                        .commit();
            }
        });
    }
}
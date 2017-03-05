package com.mikescamell.sharedelementtransitions.picasso_fragment_to_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;
import com.squareup.picasso.Picasso;

public class PicassoFragmentA extends Fragment {

    public static final String TAG = PicassoFragmentA.class.getSimpleName();
    public static String GIRAFFE_PIC_URL = "http://ichef.bbci.co.uk/naturelibrary/images/ic/credit/640x395/g/gi/giraffe/giraffe_1.jpg";

    public PicassoFragmentA() {
        // Required empty public constructor
    }

    public static PicassoFragmentA newInstance() {
        return new PicassoFragmentA();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.picasso_fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView imageView = (ImageView) view.findViewById(R.id.picasso_fragment_a_imageView);
        Picasso.with(getContext())
                .load(GIRAFFE_PIC_URL)
                .fit()
                .centerCrop()
                .into(imageView);

        Button button = (Button) view.findViewById(R.id.picasso_fragment_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PicassoFragmentB simpleFragmentB = PicassoFragmentB.newInstance();
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
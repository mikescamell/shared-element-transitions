package com.mikescamell.sharedelementtransitions.picasso_fragment_to_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.BaseFragment;
import com.mikescamell.sharedelementtransitions.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoFragmentB extends BaseFragment {

    public PicassoFragmentB() {
        // Required empty public constructor
    }

    public static PicassoFragmentB newInstance() {
        return new PicassoFragmentB();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.picasso_fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView imageView = (ImageView) view.findViewById(R.id.picasso_fragment_b_image);
        Picasso.get()
                .load(PicassoFragmentA.GIRAFFE_PIC_URL)
                .noFade()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        scheduleStartPostponedTransition(imageView);
                    }

                    @Override
                    public void onError(Exception e) {
                        scheduleStartPostponedTransition(imageView);
                    }
                });
    }
}
package com.mikescamell.sharedelementtransitions.simple_fragment_to_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;

public class SimpleFragmentB extends Fragment {

    public SimpleFragmentB() {
        // Required empty public constructor
    }

    public SimpleFragmentB newInstance() {
        return new SimpleFragmentB();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.simple_fragment_transition));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.fragment_b_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.gorilla));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
package com.mikescamell.sharedelementtransitions.simple_fragment_to_fragment;

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

public class SimpleFragmentA extends Fragment {

    public static final String TAG = SimpleFragmentA.class.getSimpleName();

    public SimpleFragmentA() {
        // Required empty public constructor
    }

    public static SimpleFragmentA newInstance() {
        return new SimpleFragmentA();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView imageView = (ImageView) view.findViewById(R.id.fragment_a_imageView);

        Button button = (Button) view.findViewById(R.id.fragment_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleFragmentB simpleFragmentB = SimpleFragmentB.newInstance();
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
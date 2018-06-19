package com.mikescamell.sharedelementtransitions.picasso_fragment_to_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Transition;
import android.support.transition.TransitionInflater;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.BaseFragment;
import com.mikescamell.sharedelementtransitions.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class PicassoFragmentA extends BaseFragment {

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
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postponeEnterTransition();

        final ImageView imageView = (ImageView) view.findViewById(R.id.picasso_fragment_a_imageView);
        Picasso.get()
                .load(GIRAFFE_PIC_URL)
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

        Button button = (Button) view.findViewById(R.id.picasso_fragment_a_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Transition transition = TransitionInflater.from(requireContext()).
                        inflateTransition(R.transition.simple_fragment_transition);

                PicassoFragmentB simpleFragmentB = PicassoFragmentB.newInstance();
                simpleFragmentB.setSharedElementEnterTransition(transition);
                simpleFragmentB.setSharedElementReturnTransition(transition);

                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView, ViewCompat.getTransitionName(imageView))
                        .addToBackStack(TAG)
                        .setReorderingAllowed(true)
                        .replace(R.id.content, simpleFragmentB)
                        .commit();
            }
        });
    }

}
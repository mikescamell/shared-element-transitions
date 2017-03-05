package com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikescamell.sharedelementtransitions.R;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalItem;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AnimalDetailFragment extends Fragment {

    private static final String EXTRA_ANIMAL_ITEM = "animal_item";
    private static final String EXTRA_TRANSITION_NAME = "transition_name";

    public AnimalDetailFragment() {
        // Required empty public constructor
    }

    public static AnimalDetailFragment newInstance(AnimalItem animalItem, String transitionName) {
        AnimalDetailFragment animalDetailFragment = new AnimalDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_ANIMAL_ITEM, animalItem);
        bundle.putString(EXTRA_TRANSITION_NAME, transitionName);
        animalDetailFragment.setArguments(bundle);
        return animalDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postponeEnterTransition();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animal_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AnimalItem animalItem = getArguments().getParcelable(EXTRA_ANIMAL_ITEM);
        String transitionName = getArguments().getString(EXTRA_TRANSITION_NAME);

        TextView detailTextView = (TextView) view.findViewById(R.id.animal_detail_text);
        detailTextView.setText(animalItem.detail);

        ImageView imageView = (ImageView) view.findViewById(R.id.animal_detail_image_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageView.setTransitionName(transitionName);
        }

        Picasso.with(getContext())
                .load(animalItem.imageUrl)
                .noFade()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        startPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                        startPostponedEnterTransition();
                    }
                });
    }
}
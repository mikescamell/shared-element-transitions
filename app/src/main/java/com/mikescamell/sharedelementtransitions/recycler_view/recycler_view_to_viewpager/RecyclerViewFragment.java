package com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalGalleryAdapter;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalItem;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalItemClickListener;
import com.mikescamell.sharedelementtransitions.recycler_view.Utils;

public class RecyclerViewFragment extends Fragment implements AnimalItemClickListener {

    public static final String TAG = RecyclerViewFragment.class.getSimpleName();

    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    public static RecyclerViewFragment newInstance() {
        return new RecyclerViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AnimalGalleryAdapter animalGalleryAdapter = new AnimalGalleryAdapter(Utils.generateAnimalItems(getContext()), this);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(animalGalleryAdapter);
    }

    @Override
    public void onAnimalItemClick(int pos, AnimalItem animalItem, ImageView sharedImageView) {
        Fragment animalViewPagerFragment = AnimalViewPagerFragment.newInstance(pos, Utils.generateAnimalItems(getContext()));
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(sharedImageView, ViewCompat.getTransitionName(sharedImageView))
                .addToBackStack(TAG)
                .replace(R.id.content, animalViewPagerFragment)
                .commit();
    }
}
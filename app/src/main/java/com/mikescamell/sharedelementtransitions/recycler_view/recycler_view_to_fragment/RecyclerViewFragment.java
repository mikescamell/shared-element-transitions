package com.mikescamell.sharedelementtransitions.recycler_view.recycler_view_to_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mikescamell.sharedelementtransitions.R;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalItem;
import com.mikescamell.sharedelementtransitions.recycler_view.AnimalItemClickListener;
import com.mikescamell.sharedelementtransitions.recycler_view.RecyclerViewAdapter;

import java.util.ArrayList;

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

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(generateDummyItems(), this);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onAnimalItemClick(AnimalItem animalItem, ImageView sharedImageView, String transitionName) {
        Fragment animalDetailFragment = AnimalDetailFragment.newInstance(animalItem, transitionName);
        getFragmentManager()
                .beginTransaction()
                .addSharedElement(sharedImageView, transitionName)
                .addToBackStack(TAG)
                .replace(R.id.content, animalDetailFragment)
                .commit();
    }

    private ArrayList<AnimalItem> generateDummyItems() {
        ArrayList<AnimalItem> animalItems = new ArrayList<>();
        animalItems.add(new AnimalItem("Dog", getString(R.string.dog_blurb), "https://c1.staticflickr.com/1/188/417924629_6832e79c98_z.jpg?zz=1"));
        animalItems.add(new AnimalItem("Penguin", getString(R.string.penguin_blurb), "https://c1.staticflickr.com/9/8616/16237154608_c5489cae31_z.jpg"));
        animalItems.add(new AnimalItem("Eagle", getString(R.string.eagle_blurb), "https://c1.staticflickr.com/5/4010/4210875342_7cb06a9b62_z.jpg?zz=1"));
        animalItems.add(new AnimalItem("Rabbit", getString(R.string.rabbit_blurb), "https://c2.staticflickr.com/4/3285/2819978026_175072995a_z.jpg?zz=1"));
        animalItems.add(new AnimalItem("Dolphin", getString(R.string.dolphin_blurb), "https://c1.staticflickr.com/8/7619/16124006043_60bc4d8ca5_z.jpg"));
        animalItems.add(new AnimalItem("Snek", getString(R.string.snek_blurb), "https://c1.staticflickr.com/9/8796/17158681740_a6caa5099f_z.jpg"));
        animalItems.add(new AnimalItem("Seal", getString(R.string.seal_blurb), "https://c1.staticflickr.com/4/3852/14729534910_62b338dd72_z.jpg"));
        animalItems.add(new AnimalItem("Rhino", getString(R.string.rhino_blurb), "https://c1.staticflickr.com/1/335/18040640224_f56f05f8dc_z.jpg"));
        animalItems.add(new AnimalItem("Leopard", getString(R.string.leopard_blurb), "https://c1.staticflickr.com/9/8678/16645189230_b0e96e7af9_z.jpg"));
        animalItems.add(new AnimalItem("Hippo", getString(R.string.hippo_blurb), "https://c2.staticflickr.com/4/3774/9377370000_6a57d1cfec_z.jpg"));
        return animalItems;
    }
}
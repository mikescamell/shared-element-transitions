package com.mikescamell.sharedelementtransitions.recycler_view;

import android.widget.ImageView;

/**
 * Created by msc10 on 19/02/2017.
 */

public interface AnimalItemClickListener {
    void onAnimalItemClick(int pos, AnimalItem animalItem, ImageView shareImageView);
}
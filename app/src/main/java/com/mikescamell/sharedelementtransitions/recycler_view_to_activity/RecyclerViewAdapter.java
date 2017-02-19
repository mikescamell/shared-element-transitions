package com.mikescamell.sharedelementtransitions.recycler_view_to_activity;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikescamell.sharedelementtransitions.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by msc10 on 16/02/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder> {

    private final AnimalItemClickListener animalItemClickListener;
    private ArrayList<AnimalItem> animalItems;

    public RecyclerViewAdapter(ArrayList<AnimalItem> animalItems, AnimalItemClickListener animalItemClickListener) {
        this.animalItems = animalItems;
        this.animalItemClickListener = animalItemClickListener;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_animal_square, parent, false));
    }

    @Override
    public int getItemCount() {
        return animalItems.size();
    }

    @Override
    public void onBindViewHolder(final ImageViewHolder holder, final int position) {
        final AnimalItem animalItem = animalItems.get(position);

        Picasso.with(holder.itemView.getContext())
                .load(animalItem.imageUrl)
                .into(holder.animalImageView);
        holder.animalNameTextView.setText(animalItem.name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    holder.animalImageView.setTransitionName("animal_image_" + String.valueOf(position));
                }
                animalItemClickListener.onAnimalItemClick(animalItem, holder.animalImageView);
            }
        });

    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView animalImageView;
        private TextView animalNameTextView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            animalImageView = (ImageView) itemView.findViewById(R.id.item_animal_square_image);
            animalNameTextView = (TextView) itemView.findViewById(R.id.item_animal_square_text);
        }
    }
}

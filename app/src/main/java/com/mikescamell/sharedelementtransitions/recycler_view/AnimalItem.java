package com.mikescamell.sharedelementtransitions.recycler_view;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by msc10 on 16/02/2017.
 */
public class AnimalItem implements Parcelable {

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<AnimalItem> CREATOR = new Parcelable.Creator<AnimalItem>() {
        @Override
        public AnimalItem createFromParcel(Parcel in) {
            return new AnimalItem(in);
        }

        @Override
        public AnimalItem[] newArray(int size) {
            return new AnimalItem[size];
        }
    };

    public String name;
    public String detail;
    public String imageUrl;

    public AnimalItem(String name, String detail, String imageUrl) {
        this.name = name;
        this.detail = detail;
        this.imageUrl = imageUrl;
    }

    protected AnimalItem(Parcel in) {
        name = in.readString();
        detail = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(detail);
        dest.writeString(imageUrl);
    }
}
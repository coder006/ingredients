package com.paranoidgems.ingredients.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paranoidgems.ingredients.R;

public class TodaysDishFragment extends Fragment{
    /**
     * This method is automatically called when activity creation completes.
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Setting typefaces of the labels
        Typeface tf = Typeface.createFromAsset(getActivity()
                        .getApplicationContext().getAssets(),
                "fonts/roboto-regular.ttf");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_todays_dish, container,
                false);
        return rootView;
    }
}

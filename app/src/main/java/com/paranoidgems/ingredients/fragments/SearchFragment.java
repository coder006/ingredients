package com.paranoidgems.ingredients.fragments;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.paranoidgems.ingredients.R;

public class SearchFragment extends Fragment{

    Typeface tf;

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
        setCard("Paneer Pakoda", "Missing Paneer, Olive oil and Flour.");
        setCard("Cheese Pakoda", "Missing Cheese, Mustard oil and Flour.");
        setCard("Franky", "Missing Onion, Olive oil and Green vegetables.");
        setCard("Aloo Chokha", "Missing Potato and Mustard oil.");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container,
                false);
        return rootView;
    }

    private void setCard(String dishNameValue, String missingTextValue){
        LayoutInflater vi = (LayoutInflater) getActivity()
                .getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.layout_dish, null);
        TextView dishName = (TextView) v.findViewById(R.id.txtDishName);
        dishName.setTypeface(tf);
        dishName.setText(dishNameValue);
        TextView missingText = (TextView) v.findViewById(R.id.txtMissingIngredients);
        missingText.setTypeface(tf);
        missingText.setText(missingTextValue);
        ImageView dishImage = (ImageView) v.findViewById(R.id.imgDish);
        dishImage.setImageDrawable(getActivity().getResources()
                .getDrawable(R.drawable.halloween));

        View container = getActivity().findViewById(R.id.sub_container_fragment_search);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 20);

        ((ViewGroup) container).addView(v, layoutParams);
    }
}

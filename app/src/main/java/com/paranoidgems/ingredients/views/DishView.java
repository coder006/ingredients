/*
 * Copyright 2014 Paranoid Gems
 * http://www.paranoidgems.com
 */

package com.paranoidgems.ingredients.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.paranoidgems.ingredients.R;
import com.paranoidgems.ingredients.content.Dish;

/**
 * This class is a custom view to show a dish as a search result.
 *
 */
public class DishView extends RelativeLayout {

    private String name;
    private String missingIngredientText;
    private String imageURL;

    private TextView lblDishName;
    private TextView lblMissingIngredients;
    private ImageView imgDish;


    public DishView(Context context, Dish dish) {
        super(context);
        //LayoutInflater.from(context).inflate(R.layout.key_value_layout, this);
    }

    public DishView(Context context, AttributeSet attrs, Dish dish) {
        super(context, attrs);

    }

    public DishView(Context context, AttributeSet attrs, int defStyle, Dish dish) {
        super(context, attrs, defStyle);

    }

}

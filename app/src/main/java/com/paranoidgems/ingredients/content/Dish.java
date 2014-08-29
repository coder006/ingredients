/*
 * Copyright 2014 Paranoid Gems
 * http://www.paranoidgems.com
 */

package com.paranoidgems.ingredients.content;

import android.content.Context;

/**
 * This class represents a dish data structure.
 *
 * Created by mrsud on 29/8/14.
 */
public class Dish {

    private String name;
    private int calorificValue;
    private int likes;
    private int numberOfIngredients;
    private Ingredient[] ingredients;

    /**
     * Public constructor to instantiate a dish.
     *
     * @param name
     * @param numberOfIngredients
     * @param calorificValue
     * @param ingredients
     */
    public Dish(Context ctx,
                String name,
                int numberOfIngredients,
                int calorificValue,
                int likes,
                Ingredient [] ingredients){
        this.name = name;
        this.numberOfIngredients = numberOfIngredients;
        this.calorificValue = calorificValue;
        this.likes = likes;
        this.ingredients = ingredients;
    }

    /**
     * Set name of the dish.
     *
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name of the dish.
     *
     * @return name
     */
    public String getName(){
        if(this.name != null)
            return this.name;
        else
            return "Unknown";
    }

    /**
     * Set ingredients of the dish.
     *
     * @param ingredients
     */
    public void setIngredients(Ingredient [] ingredients){
        this.ingredients = ingredients;
    }

    /**
     * Get ingredients of the dish.
     *
     * @return ingredients
     */
    public Ingredient [] getIngredients(){
        return this.ingredients;
    }

    /**
     * Set calorific value of the dish.
     *
     * @param calorificValue
     */
    public void setCalorificValue(int calorificValue){
        this.calorificValue = calorificValue;
    }

    /**
     * Get calorific value of the dish.
     *
     * @return calorificValue
     */
    public int getCalorificValue(){
        return this.calorificValue;
    }

    /**
     * Like the dish. This method increases the global like count
     * of the dish.
     */
    public void like(){
        this.likes++;
    }

    /**
     * Unlike the dish. This method decreases the global like count
     * of the dish.
     */
    public void unlike(){
        this.likes--;
    }

}

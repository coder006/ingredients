/*
 * Copyright 2014 Paranoid Gems
 * http://www.paranoidgems.com
 */

package com.paranoidgems.ingredients;


/**
 * This class represents an ingredient data structure.
 *
 * Created by mrsud on 29/8/14.
 */
public class Ingredient {

    private String name;
    private String amount;

    /**
     * Public constructor to instantiate an ingredient
     * with its name.
     *
     * @param name
     */
    public Ingredient(String name){
        this.name = name;
    }

    /**
     * Public constructor to instantiate an ingredient
     * with its name and amount.
     *
     * @param name
     * @param amount
     */
    public Ingredient(String name, String amount){
        this.name = name;
        this.amount = amount;
    }

    /**
     * Set name of the ingredient.
     *
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get name of the ingredient.
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
     * Set amount of the ingredient,
     *
     * @param amount
     */
    public void setAmount(String amount){
        this.amount = amount;
    }

    /**
     * Get amount of the ingredient.
     *
     * @return
     */
    public String getAmount() {
        return this.name;
    }

}

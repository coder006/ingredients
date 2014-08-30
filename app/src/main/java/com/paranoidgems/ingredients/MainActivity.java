/*
 * Copyright 2014 Paranoid Gems
 * http://www.paranoidgems.com
 */

package com.paranoidgems.ingredients;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.paranoidgems.ingredients.fragments.SearchFragment;
import com.paranoidgems.ingredients.fragments.TodaysDishFragment;

import java.util.ArrayList;

/**
 * Class for main activity.
 *
 */
public class MainActivity extends FragmentActivity {

    private NavDrawerListAdapter adapter;
    private DrawerLayout mDrawerLayout;

    private ListView mDrawerList;

    // nav drawer title
    private CharSequence mDrawerTitle;

    private ActionBarDrawerToggle mDrawerToggle;
    // used to store app title
    private CharSequence mTitle;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private TypedArray navMenuIcons;

    // slide menu items
    private String[] navMenuTitles;


    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set screen orientation to portrait
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Styling ActionBar
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(
                getResources().getColor(R.color.pink)
        ));

        this.mTitle = this.mDrawerTitle = getTitle();
        this.navMenuTitles = getResources().getStringArray(
                R.array.nav_drawer_items);
        this.navMenuIcons = getResources().obtainTypedArray(
                R.array.nav_drawer_icons);
        this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
        this.navDrawerItems = new ArrayList<NavDrawerItem>();
        this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[0],
                this.navMenuIcons.getResourceId(0, -1)));
        this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[1],
                this.navMenuIcons.getResourceId(1, -1)));
        this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[2],
                this.navMenuIcons.getResourceId(2, -1)));
        this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[3],
                this.navMenuIcons.getResourceId(3, -1)));
        this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[4],
                this.navMenuIcons.getResourceId(4, -1)));
        this.navDrawerItems.add(new NavDrawerItem(this.navMenuTitles[5],
                this.navMenuIcons.getResourceId(5, -1)));

        this.navMenuIcons.recycle();

        this.adapter = new NavDrawerListAdapter(getApplicationContext(),
                this.navDrawerItems);
        this.mDrawerList.setAdapter(this.adapter);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        this.mDrawerToggle = new ActionBarDrawerToggle(this,
                this.mDrawerLayout, R.drawable.ic_navigation_drawer, // nav menu toggle
                // icon
                R.string.app_name, // nav drawer open - description for
                // accessibility
                R.string.app_name // nav drawer close - description for
                // accessibility
        ) {
            @Override
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(MainActivity.this.mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(MainActivity.this.mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);

        if (savedInstanceState == null) {
            // Open particular fragment
            if (getIntent().getIntExtra("which_fragment", 0) == 0) {
                displayView(0);
            }
            if (getIntent().getIntExtra("which_fragment", 0) == 1) {
                displayView(1);
            }
            if (getIntent().getIntExtra("which_fragment", 0) == 2) {
                displayView(2);
            }
            if (getIntent().getIntExtra("which_fragment", 0) == 3) {
                displayView(3);
            }
        }
        this.mDrawerList.setOnItemClickListener(new SlideMenuClickListener());


    }

    /**
     * Method responsible for changing fragments
     *
     * @param position
     */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new SearchFragment();
                break;
            case 1:
                fragment = new TodaysDishFragment();
                break;
            case 2:
                fragment = new SearchFragment();
                break;
            case 3:
                fragment = new TodaysDishFragment();
                break;
            case 4:
                fragment = new SearchFragment();
                break;
            case 5:
                fragment = new TodaysDishFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            this.mDrawerList.setItemChecked(position, true);
            this.mDrawerList.setSelection(position);
            setTitle(this.navMenuTitles[position]);
            this.mDrawerLayout.closeDrawer(this.mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer
        this.mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (this.mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            // case R.id.action_settings:
            // return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        this.mDrawerToggle.syncState();
    }

    /**
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mDrawerLayout.isDrawerOpen(this.mDrawerList);
        // menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }


    /**
     * Method to set title of the action bar
     */
    @Override
    public void setTitle(CharSequence title) {
        this.mTitle = title;
        getActionBar().setTitle(this.mTitle);
    }
}

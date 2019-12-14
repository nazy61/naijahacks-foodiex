package com.nazycodes.foodiex.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nazycodes.foodiex.fragments.ByNumberOfPersonsFragment;
import com.nazycodes.foodiex.fragments.ByPotFragment;

public class OrderViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 2;

    public OrderViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ByPotFragment();
            case 1:
                return new ByNumberOfPersonsFragment();
            }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return ByPotFragment.TITLE;
            case 1:
                return ByNumberOfPersonsFragment.TITLE;
            }

        return super.getPageTitle(position);
    }
}
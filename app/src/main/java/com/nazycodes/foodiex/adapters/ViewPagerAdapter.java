package com.nazycodes.foodiex.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.nazycodes.foodiex.fragments.DetailsFragment;
import com.nazycodes.foodiex.fragments.HealthBenefitsFragment;
import com.nazycodes.foodiex.fragments.HowToCookFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 3;

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DetailsFragment();
            case 1:
                return new HealthBenefitsFragment();
            case 2:
                return new HowToCookFragment();
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
                return DetailsFragment.TITLE;
            case 1:
                return HealthBenefitsFragment.TITLE;
            case 2:
                return HowToCookFragment.TITLE;
        }

        return super.getPageTitle(position);
    }
}

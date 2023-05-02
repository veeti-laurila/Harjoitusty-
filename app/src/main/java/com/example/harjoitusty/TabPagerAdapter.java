package com.example.harjoitusty;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.harjoitusty.fragments.FragmentHome;
import com.example.harjoitusty.fragments.FragmentTraining;
import com.example.harjoitusty.fragments.FragmentFight;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentTraining();
            case 2:
                return new FragmentFight();
            default:
                return new FragmentHome();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

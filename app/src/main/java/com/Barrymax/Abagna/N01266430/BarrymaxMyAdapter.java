package com.Barrymax.Abagna.N01266430;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class BarrymaxMyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public BarrymaxMyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                BarrymaxFragment barrymaxFragment = new BarrymaxFragment();
                return barrymaxFragment;
            case 1:
                AbagnaFragment abagnaFragment = new AbagnaFragment();
                return abagnaFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

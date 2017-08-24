package com.bignerdranch.android.bottomtabwlh.viewpage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bignerdranch.android.bottomtabwlh.DataGenerator;

/**
 * Created by Administrator on 2017/8/24/024.
 */

public class MyFragmentViewPage extends FragmentStatePagerAdapter {
    private Fragment[] mFragments;

    public MyFragmentViewPage(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments[position];
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return DataGenerator.sTabTitle[position];
    }
}

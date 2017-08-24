package com.bignerdranch.android.bottomtabwlh;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private int lastClick;

    private FrameLayout mFragmentContainer;
    private TabLayout mTabLayout;
    private Fragment[] fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = DataGenerator.getFragments();
        initView();
    }

    private void initView() {
        mFragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                setFragment(tab.getPosition());

                View lastV = mTabLayout.getTabAt(lastClick).getCustomView();
                ImageView imageLast = (ImageView) lastV.findViewById(R.id.tab_image);
                imageLast.setImageResource(DataGenerator.sTabRes[lastClick]);

                lastClick = tab.getPosition();

                View v = tab.getCustomView();
                ImageView image = (ImageView) v.findViewById(R.id.tab_image);
                image.setImageResource(DataGenerator.sTabResPressed[lastClick]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        for (int i = 0; i < 4; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)));
        }
    }

    private void setFragment(int position) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container, fragments[position]).commit();
    }
}

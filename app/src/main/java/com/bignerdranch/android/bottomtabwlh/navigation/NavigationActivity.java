package com.bignerdranch.android.bottomtabwlh.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.bignerdranch.android.bottomtabwlh.DataGenerator;
import com.bignerdranch.android.bottomtabwlh.R;

public class NavigationActivity extends AppCompatActivity {
    private Fragment[] mFragments;
    private FrameLayout fragment_container;
    private BottomNavigationView navigation_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mFragments = DataGenerator.getFragments();
        initView();
    }

    private void initView() {
        fragment_container = (FrameLayout) findViewById(R.id.fragment_container);
        navigation_bottom = (BottomNavigationView) findViewById(R.id.navigation_bottom);
        navigation_bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                setFragment(item.getItemId());
                return true;
            }
        });

        setFragment(R.id.home);
    }

    private void setFragment(@NonNull int item) {
        Fragment fragment = null;
        switch (item) {
            case R.id.home:
                fragment = mFragments[0];
                break;
            case R.id.search:
                fragment = mFragments[1];
                break;
            case R.id.favorite:
                fragment = mFragments[2];
                break;
            case R.id.mine:
                fragment = mFragments[3];
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}

package com.bignerdranch.android.bottomtabwlh.viewpage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bignerdranch.android.bottomtabwlh.DataGenerator;
import com.bignerdranch.android.bottomtabwlh.R;

public class TabPageActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);
        initView();
    }

    private void initView() {
        mViewPage = (ViewPager) findViewById(R.id.view_page_tab);
        MyFragmentViewPage adapter = new MyFragmentViewPage(getSupportFragmentManager(), DataGenerator.getFragments());
        mViewPage.setAdapter(adapter);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

        mTabLayout.setupWithViewPager(mViewPage);

        mTabLayout.removeAllTabs();
        int size = DataGenerator.sTabTitle.length;
        for (int i = 0; i < size; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)));
        }
    }
}

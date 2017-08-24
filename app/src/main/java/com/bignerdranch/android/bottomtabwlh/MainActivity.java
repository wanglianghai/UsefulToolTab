package com.bignerdranch.android.bottomtabwlh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bignerdranch.android.bottomtabwlh.navigation.NavigationActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTabButton;
    private Button mNavigationBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabButton = (Button) findViewById(R.id.tab_button);
        mTabButton.setOnClickListener(this);

        mNavigationBottom = (Button) findViewById(R.id.navigation_bottom);
        mNavigationBottom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_button:
                startActivity(new Intent(this, TabActivity.class));
                break;
            case R.id.navigation_bottom:
                startActivity(new Intent(this, NavigationActivity.class));
                break;
        }
    }
}

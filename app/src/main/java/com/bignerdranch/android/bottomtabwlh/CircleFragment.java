package com.bignerdranch.android.bottomtabwlh;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

public class CircleFragment extends Fragment  {

    private TextView textTitle;
    private String title;

    public static CircleFragment newInstance(String s) {
        CircleFragment r = new CircleFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", s);
        r.setArguments(bundle);
        return r;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_normal, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        title = getArguments().getString("title");
        textTitle = (TextView) view.findViewById(R.id.text_title);
        textTitle.setText(title);
    }

}

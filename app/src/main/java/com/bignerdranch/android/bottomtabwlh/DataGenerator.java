package com.bignerdranch.android.bottomtabwlh;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/23/023.
 */

public class DataGenerator {
    public static final int[] sTabResSelect = {R.drawable.select_tab_strip_triangle, R.drawable.select_tab_strip_rectangle, R.drawable.select_tab_strip_rhombus, R.drawable.select_tab_strip_circle};
    public static final int[] sTabResPressed = {R.drawable.ic_tab_strip_icon_triangle_selected, R.drawable.ic_tab_strip_icon_rectangle_selected, R.drawable.ic_tab_strip_icon_rhombus_selected, R.drawable.ic_tab_strip_icon_circle_selected};
    public static final int[] sTabRes = {R.drawable.ic_tab_strip_icon_triangle, R.drawable.ic_tab_strip_icon_rectangle, R.drawable.ic_tab_strip_icon_rhombus, R.drawable.ic_tab_strip_icon_circle};
    public static final String[] sTabTitle = {"triangle", "rectangle", "rhombus", "circle"};

    public static Fragment[] getFragments() {
        Fragment[] fragments = new Fragment[4];
        fragments[0] = TriangleFragment.newInstance("triangle");
        fragments[1] = RectangleFragment.newInstance("rectangle");
        fragments[2] = RhombusFragment.newInstance("rhombus");
        fragments[3] = CircleFragment.newInstance("circle");
        return fragments;
    }

    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_image);
        imageView.setImageResource(sTabRes[position]);
        TextView textView = (TextView) view.findViewById(R.id.tab_text);
        textView.setText(sTabTitle[position]);
        return view;
    }
}

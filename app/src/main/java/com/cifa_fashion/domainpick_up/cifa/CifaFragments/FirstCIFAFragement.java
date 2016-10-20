package com.cifa_fashion.domainpick_up.cifa.CifaFragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cifa_fashion.domainpick_up.cifa.R;

public class FirstCIFAFragement extends CifaFragment {
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        LinearLayout mainLayout = new LinearLayout(getContext());
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        TextView textViewTitle = new TextView(getContext());
        textViewTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        textViewTitle.setText(R.string.first_fifa_fragment);
        mainLayout.addView(textViewTitle);
        return mainLayout;
    }
}

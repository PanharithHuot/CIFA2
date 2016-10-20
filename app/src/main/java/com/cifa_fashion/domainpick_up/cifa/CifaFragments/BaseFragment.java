package com.cifa_fashion.domainpick_up.cifa.CifaFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cifa_fashion.domainpick_up.cifa.MainActivity;

public class BaseFragment extends CifaFragment {
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        LinearLayout mainLayout = new LinearLayout(getContext());
        ((MainActivity)getActivity()).showProgressBar(false);
        return mainLayout;
    }

}

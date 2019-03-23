package com.example.vivianbabiryekulumba.ssappmarkupone.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.ssappmarkupone.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFrag extends Fragment {

    LinearLayout more_bar_ll;
    TextView more_bar_tv;
    Button terms;
    Button policy;
    Button about_us;

    public static MoreFrag newInstance() {
        return new MoreFrag();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        more_bar_ll = view.findViewById(R.id.more_bar_ll);
        more_bar_tv = view.findViewById(R.id.more_title_text);
        terms = view.findViewById(R.id.terms_and_agreement_button);
        policy = view.findViewById(R.id.privacy_policy_button);
        about_us = view.findViewById(R.id.about_us_button);
        return view;
    }

}

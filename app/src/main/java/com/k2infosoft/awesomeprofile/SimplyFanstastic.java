package com.k2infosoft.awesomeprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kaushal on 10/12/16.
 */
public class SimplyFanstastic extends Fragment {

    public SimplyFanstastic() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_simply_fanstastic, container, false);
        return rootView;
    }

}

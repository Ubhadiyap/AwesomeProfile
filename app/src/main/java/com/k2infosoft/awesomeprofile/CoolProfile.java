package com.k2infosoft.awesomeprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kaushal on 10/12/16.
 */
public class CoolProfile extends Fragment {
    @BindView(R.id.wave_head)
    ImageView _profile_pic;

    public CoolProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cool_profile, container, false);
        ButterKnife.bind(this, rootView);

        try {
            Glide.with(this).load(R.drawable.kaushal).into(_profile_pic);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }

}

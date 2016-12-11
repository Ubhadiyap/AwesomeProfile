package com.k2infosoft.awesomeprofile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StylistProfile extends Fragment {
    @BindView(R.id.header)
    com.flaviofaria.kenburnsview.KenBurnsView _header_image;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_stylist_profile, container, false);
        ButterKnife.bind(this, rootView);
        // Inflate the layout for this fragment

        try {
            Glide.with(this).load(R.drawable.bike_wallpaper).into(_header_image);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }

}

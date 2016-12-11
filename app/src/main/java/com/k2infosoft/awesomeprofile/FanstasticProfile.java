package com.k2infosoft.awesomeprofile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mcs.easysocial.EasySocialAppMod.openFacebookProfile;
import static com.mcs.easysocial.EasySocialAppMod.openGooglePlusProfile;
import static com.mcs.easysocial.EasySocialAppMod.openTwitterProfile;
import static com.mcs.easysocial.EasyViewMod.progressDialog;

/**
 * Created by kaushal on 10/12/16.
 */
public class FanstasticProfile extends Fragment implements View.OnClickListener {
    @BindView(R.id.facebook)
    com.k2infosoft.social_login.FacebookButton _facebook;
    @BindView(R.id.google)
    com.k2infosoft.social_login.GooglePlusButton _google;
    @BindView(R.id.twitter)
    com.k2infosoft.social_login.TwitterButton _twitter;
    @BindView(R.id.img_profile)
    ImageView _profile_pic;
    @BindView(R.id.tv_email)
    TextView _email;
    @BindView(R.id.tv_github)
    TextView _github;
    @BindView(R.id.wave_head)
    com.intrusoft.library.FrissonView _wave_header;

    private ProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_fanstastic_profile, container, false);
        ButterKnife.bind(this, rootView);
        _facebook.setOnClickListener(this);
        _google.setOnClickListener(this);
        _twitter.setOnClickListener(this);

        try {
            Glide.with(this).load(R.drawable.kaushal).into(_profile_pic);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.facebook:
                mProgressDialog = progressDialog(getActivity(), ProgressDialog.STYLE_SPINNER, "loading", true, true);
                mProgressDialog.show();
                if (!openFacebookProfile(getActivity(), "kaushalkishorenk", true, "not installed!", "no connection!")) {
                    //app not installed...execute something here!
                    FragmentManager fmWV = getActivity().getSupportFragmentManager();
                    WebViewDialog wvDialog = WebViewDialog.newInstance(
                            "https://www.facebook.com/profile.php?id=" + "kaushalkishorenk"
                    );
                    wvDialog.show(fmWV, "WVDialog!");
                }
                mProgressDialog.hide();
                break;
            case R.id.google:
                mProgressDialog = progressDialog(getActivity(), ProgressDialog.STYLE_SPINNER, "loading", true, true);
                mProgressDialog.show();
                if (!openGooglePlusProfile(getActivity(), "101203503761123441990", true, "not installed!", "no connection!")) {
                    //app not installed...execute something here!
                    FragmentManager fmWV = getActivity().getSupportFragmentManager();
                    WebViewDialog wvDialog = WebViewDialog.newInstance(
                            "https://plus.google.com/" + "101203503761123441990"
                    );
                    wvDialog.show(fmWV, "WVDialog!");
                }
                mProgressDialog.hide();
                break;
            case R.id.twitter:
                mProgressDialog = progressDialog(getActivity(), ProgressDialog.STYLE_SPINNER, "loading", true, true);
                mProgressDialog.show();
                if (!openTwitterProfile(getActivity(), "kaushalkishor19", true, "not installed!", "no connection!")) {
                    //app not installed...execute something here!
                    FragmentManager fmWV = getActivity().getSupportFragmentManager();
                    WebViewDialog wvDialog = WebViewDialog.newInstance(
                            "https://www.twitter.com/" + "kaushalkishor19"
                    );
                    wvDialog.show(fmWV, "WVDialog!");
                }
                mProgressDialog.hide();
                break;

        }
    }
}

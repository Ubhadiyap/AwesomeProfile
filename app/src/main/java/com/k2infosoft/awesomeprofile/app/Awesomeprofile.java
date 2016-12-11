package com.k2infosoft.awesomeprofile.app;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.flurry.android.FlurryAgent;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by hp pavilion on 11-12-2016.
 */

public class Awesomeprofile extends Application {

    public static final String TAG = Awesomeprofile.class
            .getSimpleName();

    public static String MY_FLURRY_APIKEY ="PZMZFYGW25JSSJ47ZDX7";


    private static Awesomeprofile mInstance;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        PackageInfo pInfo;
        try {
            pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;

            FlurryAgent.setVersionName(version);
            FlurryAgent.init(this,MY_FLURRY_APIKEY);
            FlurryAgent.setReportLocation(true);


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.k2infosoft.awesomeprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kobakei.ratethisapp.RateThisApp;

/**
 * Created by kaushal on 10/12/16.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment = null;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    TextView headername, designation;
    de.hdodenhof.circleimageview.CircleImageView headerimage;
    com.flaviofaria.kenburnsview.KenBurnsView background;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        com.kobakei.ratethisapp.RateThisApp.init(new com.kobakei.ratethisapp.RateThisApp.Config(3, 5));
        com.kobakei.ratethisapp.RateThisApp.Config config = new com.kobakei.ratethisapp.RateThisApp.Config();
        config.setUrl("https://k2infosoft.store.aptoide.com/app/market/com.k2infosoft.awesomeprofile/1/22321804/AWESOME-PROFILE");
        com.kobakei.ratethisapp.RateThisApp.init(config);

        // Set callback (optional)
        RateThisApp.setCallback(new RateThisApp.Callback() {
            @Override
            public void onYesClicked() {

            }

            @Override
            public void onNoClicked() {

            }

            @Override
            public void onCancelClicked() {

            }
        });


        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_container, new FanstasticProfile()).commit();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header = LayoutInflater.from(this).inflate(R.layout.nav_header_main, null);
        navigationView.addHeaderView(header);

        headername = (TextView) header.findViewById(R.id.headername);
        designation = (TextView) header.findViewById(R.id.designation);
        headerimage = (de.hdodenhof.circleimageview.CircleImageView) header.findViewById(R.id.avatar);
        background = (com.flaviofaria.kenburnsview.KenBurnsView) header.findViewById(R.id.background);

        try {
            Glide.with(this).load(R.drawable.kaushal).into(headerimage);
            Glide.with(this).load(R.drawable.bike_wallpaper).into(background);

        } catch (Exception e) {
            e.printStackTrace();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        String mTitle = getString(R.string.app_name);
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new FanstasticProfile()).commit();
           /* fragment = new FanstasticProfile();*/
        } else if (id == R.id.nav_gallery) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new AwesomeProfile()).commit();
            /*fragment = new AwesomeProfile();*/
        } else if (id == R.id.nav_slideshow) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new CoolProfile()).commit();
            /*fragment = new CoolProfile();*/
        } else if (id == R.id.nav_manage) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new SimplyFanstastic()).commit();
            /*fragment = new SimplyFanstastic();*/
        } else if (id == R.id.nav_share) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new StylistProfile()).commit();
            /*fragment = new StylistProfile();*/
        } else if (id == R.id.nav_send) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app source at:https://github.com/kaushalkishore1");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        } else if (id == R.id.nav_rate) {
            com.kobakei.ratethisapp.RateThisApp.showRateDialog(MainActivity.this);
        } else {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, new AwesomeProfile()).commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

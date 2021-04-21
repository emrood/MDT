package com.mdt.app.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.mdt.app.models.news;
import com.mdt.app.models.new_medias;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.mdt.app.R;
import com.mdt.app.ui.fragments.Home;
import com.mdt.app.ui.fragments.Messages;
import com.mdt.app.ui.fragments.NewsDetail;
import com.mdt.app.ui.fragments.Services;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main extends AppCompatActivity {


    @BindView(R.id.topAppBar) MaterialToolbar toolbar;
    @BindView(R.id.navigation_view) NavigationView navigationView;
    @BindView(R.id.drawerLayout) DrawerLayout drawerLayout;
    @BindView(R.id.fragment_container) FrameLayout container;

    private Messages messages;
    private Services services;
    private Home home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // INIT ALL FRAGMENTS
        messages = new Messages();
        services = new Services();
        home = new Home();

        inflateFragment(home);

        navigationView.setNavigationItemSelectedListener(item -> {
            // TODO ADD OTHER ITEMS
            switch (item.getItemId()){
                case R.id.menu_messages:
                    inflateFragment(messages);
                    break;
                case R.id.menu_services:
                    inflateFragment(services);
                    break;
                case R.id.menu_home:
                default:
                    inflateFragment(home);
                    break;
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    public void inflateFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void showNews(news mNews){
        NewsDetail newsDetail = NewsDetail.newInstance(mNews);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newsDetail);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
package com.kewenc.deskmemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.kewenc.deskmemo.R;
import com.kewenc.deskmemo.presenter.BaseActivity;
import com.kewenc.deskmemo.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainInterface,MainPresenter>
        implements MainInterface, View.OnClickListener,NavigationView.OnNavigationItemSelectedListener {

    private MainPresenter mainPresenter;
    private Toolbar toolbar;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private MemoFragment memoFragment;
    private BirthdayFragment birthdayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        mainPresenter.showToolbar();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected MainPresenter createPresenter() {
        mainPresenter = new MainPresenter(this, this);
        return mainPresenter;
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_memo) {
            // Handle the camera action
            mainPresenter.enterMemoFragment();
        } else if (id == R.id.nav_gallery) {
            mainPresenter.enterBirthdayFragment();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void showToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void showFloatingActionButton(View v) {
        startActivity(new Intent(MainActivity.this, AddMemoActivity.class));
//        Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show();
    }

    @Override
    public void enterMemoFragment() {
        memoFragment = new MemoFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, memoFragment);
        transaction.commit();
    }

    @Override
    public void enterBirthdayFragment() {
        birthdayFragment = new BirthdayFragment();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content, birthdayFragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:
                mainPresenter.showFloatingActionButton(v);
                break;
            default:
                break;
        }
    }
}

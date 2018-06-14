package com.linx.xueandroid.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.linx.xueandroid.R;
import com.linx.xueandroid.base.RxBaseActivity;
import com.linx.xueandroid.ui.fragment.HomeFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.TimeUnit;

import io.reactivex.functions.Consumer;

public class MainActivity extends RxBaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {


        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        RxView.clicks(fab).throttleFirst(2, TimeUnit.SECONDS).subscribe(o -> {
//            EventBus.getDefault().post(new TestEvent());
//        });
        RxView.clicks(fab).throttleFirst(2, TimeUnit.SECONDS).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {

//                EasyHttp.get("article/list/1/json").execute(new SimpleCallBack<String>() {
//                    @Override
//                    public void onError(ApiException e) {
//                        super.onError(e);
//                    }
//
//                    @Override
//                    public void onSuccess(String o) {
//                        ToastUtil.LongToast(o.toString());
//                    }
//                });
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    HomeFragment homeFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("首页");
//                    if (homeFragment == null) {
                        homeFragment = new HomeFragment();
//                    }
                    showFragment(homeFragment);
                    return true;
                case R.id.navigation_dashboard:
                    toolbar.setTitle("其他");
                    return true;
                case R.id.navigation_notifications:
                    toolbar.setTitle("通知");
                    return true;
            }
            return false;
        }
    };

    @Override
    public void initToolBar() {

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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String
                                e) {
        Toast.makeText(this, "aa", Toast.LENGTH_LONG).show();
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void showFragment(Fragment fg) {

        FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fg);
        transaction.commit();

    }

}

package com.cifa_fashion.domainpick_up.cifa;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.cifa_fashion.domainpick_up.cifa.CifaFragments.CifaFragment;
import com.cifa_fashion.domainpick_up.cifa.CifaFragments.FirstCIFAFragement;
import com.cifa_fashion.domainpick_up.cifa.CifaFragments.BaseFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showProgressBar(true);
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            BaseFragment firstFragment = new BaseFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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
    public void showProgressBar(boolean show){
        if(show)
            findViewById(R.id.material_design_ball_spin_fade_loader).setVisibility(View.VISIBLE);
        else
            findViewById(R.id.material_design_ball_spin_fade_loader).setVisibility(View.GONE);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.les_colis_en_attente) {
            addFragment(new FirstCIFAFragement());
        } else if (id == R.id.retrait_expédition) {
            addFragment(new FirstCIFAFragement());
        } else if (id == R.id.tarif_transport) {
            addFragment(new FirstCIFAFragement());
        } else if (id == R.id.annuaire) {
            addFragment(new FirstCIFAFragement());
        }else if(id == R.id.facturation){
            addFragment(new FirstCIFAFragement());
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addFragment(CifaFragment fragment){
        if (findViewById(R.id.fragment_container) != null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();
        }
    }
    public void pushFragment(CifaFragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
    public void popFragment(){
        getSupportFragmentManager().popBackStack();
    }
}

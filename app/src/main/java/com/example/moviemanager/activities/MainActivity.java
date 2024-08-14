package com.example.moviemanager.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.moviemanager.R;
import com.example.moviemanager.fragments.NowPlayingFragment;
import com.example.moviemanager.fragments.UpcomingFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawyer_layout);
         ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);


        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragment(NowPlayingFragment.class);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawyer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawerLayout = findViewById(R.id.drawyer_layout);

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // TODO: Inflate the menu this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {

        // TODO: Handle action bar item clicks here. The action bar will
        // TODO: Automatically handle clicks on the HOME/UP button, so long
        // TODO: As you specify a parent activity in AndroidManifest.xml.

        int id = menuItem.getItemId();

        // TODO: No Inspection Simplifiable If Stetement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        // TODO: Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        Class fragmentClass = null;

        if (id == R.id.nav_now_playing) {
            fragmentClass = NowPlayingFragment.class;
            showFragment(fragmentClass);

        } else if (id == R.id.nav_upcoming) {
            fragmentClass = UpcomingFragment.class;
            showFragment(fragmentClass);

        } else if (id == R.id.nav_logout) {
            // Snackbar.make(findViewById(R.id.main), "Kinza Amjad is so so much chocolaty", Snackbar.LENGTH_LONG).show();
            Toast.makeText(this, "Kinza Amjad is so so much chocolaty", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawyer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    private void showFragment(Class fragmentClass) {

        Fragment fragment = null;

        try {
            fragment = (Fragment) fragmentClass.newInstance();

        } catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();

        } catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

    }
}
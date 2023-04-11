package com.example.starcrowdinvestorapp.UI.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.starcrowdinvestorapp.DB.SharedPrefManager;
import com.example.starcrowdinvestorapp.R;
import com.example.starcrowdinvestorapp.UI.Fragments.ArtistSearchFragment;
import com.example.starcrowdinvestorapp.UI.Fragments.HomeFragment;
import com.example.starcrowdinvestorapp.UI.Fragments.PortfolioFragment;
import com.example.starcrowdinvestorapp.UI.Fragments.StarCrowdTVFragment;
import com.example.starcrowdinvestorapp.UI.Fragments.TrendingFragment;
import com.example.starcrowdinvestorapp.UI.Fragments.WatchListFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView navView;
    TextView nameTextView, emailTextView, userTextView;

    Button logoutButton;
    FragmentTransaction fragmentTransaction;
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer);
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

        View headerView = navView.getHeaderView(0);
        nameTextView = headerView.findViewById(R.id.name_textView);
        emailTextView = headerView.findViewById(R.id.email_textView);
        userTextView = headerView.findViewById(R.id.user_textView);
        nameTextView.setText(SharedPrefManager.getInstance(this).getUser().getName());
        emailTextView.setText(SharedPrefManager.getInstance(this).getUser().getEmail());
        userTextView.setText(R.string.user);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        closeDrawer();
        if (item.getItemId() == R.id.home_menu) {
            loadFragment(new HomeFragment());
        }
        if (item.getItemId() == R.id.portfolio_menu) {
            loadFragment(new PortfolioFragment());
        }
        if (item.getItemId() == R.id.trending_menu) {
            loadFragment(new TrendingFragment());
        }
        if (item.getItemId() == R.id.watch_menu) {
            loadFragment(new WatchListFragment());
        }
        if (item.getItemId() == R.id.artist_search_menu) {
            loadFragment(new ArtistSearchFragment());
        }
        if (item.getItemId() == R.id.starcrowd_tv_menu) {
            loadFragment(new StarCrowdTVFragment());
        }
        if (item.getItemId() == R.id.settings_menu) {

        }
        if (item.getItemId() == R.id.logout_menu) {
            SharedPrefManager.getInstance(this).clear();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        return true;
    }

    private void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    public void loadFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
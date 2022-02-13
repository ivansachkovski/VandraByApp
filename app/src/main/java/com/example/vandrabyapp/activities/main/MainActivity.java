package com.example.vandrabyapp.activities.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.profile.ProfileFragment;
import com.example.vandrabyapp.activities.main.pages.swipes.SwipesFragment;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private static final String PROFILE_FRAGMENT_TAG = "ProfileFragment";
    private static final String SWIPES_FRAGMENT_TAG = "SwipesFragment";
    private static final String TRIPS_FRAGMENT_TAG = "TripsFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationBarView bottomNavigationBar = findViewById(R.id.bottom_navigation_panel);
        bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_swipes:
                    return openSwipesPage();
                case R.id.item_trips:
                    return openTripsPage();
                case R.id.item_profile:
                    return openProfilePage();
                default:
                    return false;
            }
        });

        // choose default screen
        bottomNavigationBar.setSelectedItemId(R.id.item_profile);
    }

    private boolean openSwipesPage() {
        loadFragment(SwipesFragment.newInstance(), SWIPES_FRAGMENT_TAG, true);
        return true;
    }

    private boolean openTripsPage() {
        return false;
    }

    private boolean openProfilePage() {
        loadFragment(ProfileFragment.newInstance(), PROFILE_FRAGMENT_TAG, true);
        return true;
    }

    private void loadFragment(Fragment fragment, String tag, boolean saveState) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, fragment, tag);

        if (saveState) {
            fragmentTransaction.addToBackStack(null);
        }

        fragmentTransaction.commit();
    }
}
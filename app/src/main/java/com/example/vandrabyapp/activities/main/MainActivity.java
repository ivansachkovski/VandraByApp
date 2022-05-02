package com.example.vandrabyapp.activities.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.createroute.CreateRouteFragment;
import com.example.vandrabyapp.activities.main.pages.details.PlaceDetailsFragment;
import com.example.vandrabyapp.activities.main.pages.profile.ProfileFragment;
import com.example.vandrabyapp.activities.main.pages.swipes.SwipesFragment;
import com.example.vandrabyapp.model.entities.Place;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private static final String PROFILE_FRAGMENT_TAG = "ProfileFragment";
    private static final String SWIPES_FRAGMENT_TAG = "SwipesFragment";
    private static final String CREATE_ROUTE_FRAGMENT_TAG = "CreateRouteFragment";
    private static final String PLACE_DETAILS_FRAGMENT_TAG = "PlaceDetailsFragment";

    private NavigationBarView bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationBar = findViewById(R.id.bottom_navigation_panel);
        bottomNavigationBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.item_swipes:
                    return loadSwipesPage();
                case R.id.item_routes:
                    return loadCreateRoutesPage();
                case R.id.item_profile:
                    return loadProfilePage();
                default:
                    return false;
            }
        });

        // choose default screen
        bottomNavigationBar.setSelectedItemId(R.id.item_profile);
    }

    public void openProfilePage() {
        // Open page via triggering bottom navigation bar
        bottomNavigationBar.setSelectedItemId(R.id.item_profile);
    }

    public void openPlaceDetailsPage(Place place, boolean shouldRate) {
        loadPlaceDetailsPage(place, shouldRate);
    }

    private boolean loadSwipesPage() {
        loadFragment(SwipesFragment.newInstance(), SWIPES_FRAGMENT_TAG, true);
        return true;
    }

    private boolean loadCreateRoutesPage() {
        loadFragment(CreateRouteFragment.newInstance(), CREATE_ROUTE_FRAGMENT_TAG, true);
        return true;
    }

    private boolean loadProfilePage() {
        loadFragment(ProfileFragment.newInstance(), PROFILE_FRAGMENT_TAG, true);
        return true;
    }

    private void loadPlaceDetailsPage(Place place, boolean shouldRate) {
        loadFragment(PlaceDetailsFragment.newInstance(place, shouldRate), PLACE_DETAILS_FRAGMENT_TAG, true);
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
package com.example.vandrabyapp.activities.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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

    // TextView is used as button
    private TextView buttonBack;

    private ImageButton buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBack = findViewById(R.id.text_back);
        buttonBack.setOnClickListener(view -> {
            onBackPressed();
        });

        buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(view -> {
            loadSettingsMenuPage();
        });

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
        buttonBack.setVisibility(View.INVISIBLE);
        buttonSettings.setVisibility(View.INVISIBLE);
        loadFragment(SwipesFragment.newInstance(), SWIPES_FRAGMENT_TAG, true);
        return true;
    }

    private boolean loadCreateRoutesPage() {
        buttonBack.setVisibility(View.INVISIBLE);
        buttonSettings.setVisibility(View.INVISIBLE);
        loadFragment(CreateRouteFragment.newInstance(), CREATE_ROUTE_FRAGMENT_TAG, true);
        return true;
    }

    private boolean loadProfilePage() {
        buttonBack.setVisibility(View.INVISIBLE);
        buttonSettings.setVisibility(View.VISIBLE);
        loadFragment(ProfileFragment.newInstance(), PROFILE_FRAGMENT_TAG, true);
        return true;
    }

    private void loadPlaceDetailsPage(Place place, boolean shouldRate) {
        buttonBack.setVisibility(View.VISIBLE);
        buttonSettings.setVisibility(View.INVISIBLE);
        loadFragment(PlaceDetailsFragment.newInstance(place, shouldRate), PLACE_DETAILS_FRAGMENT_TAG, true);
    }

    private void loadSettingsMenuPage() {
        buttonBack.setVisibility(View.VISIBLE);
        buttonSettings.setVisibility(View.INVISIBLE);
        // todo::load
        //loadFragment(PlaceDetailsFragment.newInstance(place, shouldRate), PLACE_DETAILS_FRAGMENT_TAG, true);
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
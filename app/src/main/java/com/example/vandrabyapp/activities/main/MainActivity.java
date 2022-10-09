package com.example.vandrabyapp.activities.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.details.PlaceDetailsFragment;
import com.example.vandrabyapp.activities.main.pages.profile.ProfileFragment;
import com.example.vandrabyapp.activities.main.pages.swipes.SwipesFragment;
import com.example.vandrabyapp.model.entities.Place;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init and configure 'buttonBack'
        // TextView is used as button
        TextView buttonBack = findViewById(R.id.text_back);
        buttonBack.setOnClickListener(view -> {
            onBackPressed();
        });

        // Init and configure 'buttonSettings'
        ImageButton buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(view -> {
            //loadSettingsMenuPage();
        });

        // Configure bottom navigation menu
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
package com.example.vandrabyapp.activities.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.login.LoginActivity;
import com.example.vandrabyapp.activities.onboarding.adapters.OnboardingStateAdapter;

import me.relex.circleindicator.CircleIndicator3;

public class OnboardingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        FragmentStateAdapter adapter = new OnboardingStateAdapter(this);

        LinearLayout layoutButtonsSkipAndNext = findViewById(R.id.layout_buttons_skip_next);
        LinearLayout layoutButtonStart = findViewById(R.id.layout_button_start);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position != adapter.getItemCount() - 1) {
                    // 1st and 2nd pages
                    layoutButtonsSkipAndNext.setVisibility(View.VISIBLE);
                    layoutButtonStart.setVisibility(View.INVISIBLE);
                } else {
                    // 3rd page
                    layoutButtonsSkipAndNext.setVisibility(View.INVISIBLE);
                    layoutButtonStart.setVisibility(View.VISIBLE);
                }
            }
        });

        CircleIndicator3 circleIndicator = findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);

        Button buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(v -> {
            // Show next onboarding picture
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        });

        Button buttonSkip = findViewById(R.id.button_skip);
        buttonSkip.setOnClickListener(v -> {
            openLoginActivity();
        });

        Button buttonStart = findViewById(R.id.button_start);
        buttonStart.setOnClickListener(v -> {
            openLoginActivity();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // todo::implement
    }

    private void openLoginActivity() {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
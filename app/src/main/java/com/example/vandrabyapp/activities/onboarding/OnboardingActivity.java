package com.example.vandrabyapp.activities.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

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

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        CircleIndicator3 circleIndicator = findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);

        Button button_skip = findViewById(R.id.button_skip);
        button_skip.setOnClickListener(v -> {
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
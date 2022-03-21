package com.example.vandrabyapp.activities.onboarding.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.vandrabyapp.R;

public class OnboardingStateAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {

    private static final int[] onboarding_pictures_ids = {
            R.drawable.image_onboarding_1,
            R.drawable.image_onboarding_2,
            R.drawable.image_onboarding_3
    };

    private static final int[] onboarding_texts_ids = {
            R.string.text_onboarding_1,
            R.string.text_onboarding_2,
            R.string.text_onboarding_3
    };

    public OnboardingStateAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return OnboardingFragment.newInstance(position);
    }

    @Override
    public int getItemCount() {
        return onboarding_pictures_ids.length;
    }

    static public class OnboardingFragment extends Fragment {

        private final int index;

        private OnboardingFragment(int index) {
            this.index = index;
        }

        public static OnboardingFragment newInstance(int index) {
            return new OnboardingFragment(index);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_onboarding_item, null);

            ImageView imageView = view.findViewById(R.id.image_onboarding_picture);
            imageView.setImageResource(onboarding_pictures_ids[index]);

            TextView textView = view.findViewById(R.id.text_onboarding_description);
            textView.setText(onboarding_texts_ids[index]);

            return view;
        }
    }
}
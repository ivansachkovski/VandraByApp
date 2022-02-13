package com.example.vandrabyapp.activities.main.pages.swipes.photopager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.swipes.photopager.adapters.SwipesPhotosStateAdapter;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class SwipesPhotoFragment extends Fragment {

    private final List<String> mPhotoUrls;

    private SwipesPhotoFragment(List<String> photoUrls) {
        mPhotoUrls = photoUrls;
    }

    public static SwipesPhotoFragment newInstance(List<String> photoUrls) {
        return new SwipesPhotoFragment(photoUrls);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main_swipes_photo, null);

        FragmentStateAdapter adapter = new SwipesPhotosStateAdapter(this, mPhotoUrls);

        ViewPager2 viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        int limit = (mPhotoUrls.size() > 1) ? mPhotoUrls.size() / 2 : 1;
        viewPager.setOffscreenPageLimit(limit);

        CircleIndicator3 circleIndicator = view.findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);
        if (mPhotoUrls.size() == 1) {
            circleIndicator.setVisibility(View.INVISIBLE);
        }

        return view;
    }
}
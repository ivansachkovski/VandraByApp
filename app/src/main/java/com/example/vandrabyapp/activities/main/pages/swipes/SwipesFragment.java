package com.example.vandrabyapp.activities.main.pages.swipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.vandrabyapp.R;

public class SwipesFragment extends Fragment {

    public static SwipesFragment newInstance() {
        return new SwipesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_swipes, null);

        return view;
    }
}
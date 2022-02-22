package com.example.vandrabyapp.activities.main.pages.createtrip;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.vandrabyapp.R;

public class CreateTripFragment extends Fragment {

    private CreateTripFragment() {
    }

    public static CreateTripFragment newInstance() {
        return new CreateTripFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_trip, null);

        return view;
    }
}
package com.example.vandrabyapp.activities.main.pages.createtrip.subpages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.createtrip.CreateTripFragmentContract;

public class CreateTripSubpage3Fragment extends Fragment {

    CreateTripFragmentContract.Presenter presenter;

    private CreateTripSubpage3Fragment(CreateTripFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public static CreateTripSubpage3Fragment newInstance(CreateTripFragmentContract.Presenter presenter) {
        return new CreateTripSubpage3Fragment(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_trip_3, null);

        Button button_save_trip = view.findViewById(R.id.button_save_trip);
        button_save_trip.setOnClickListener(v -> {
            presenter.clickSaveTrip();
        });

        return view;
    }
}
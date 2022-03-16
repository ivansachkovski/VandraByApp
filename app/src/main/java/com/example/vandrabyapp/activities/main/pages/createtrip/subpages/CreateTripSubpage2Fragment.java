package com.example.vandrabyapp.activities.main.pages.createtrip.subpages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.createtrip.CreateTripFragmentContract;

public class CreateTripSubpage2Fragment extends Fragment {

    CreateTripFragmentContract.Presenter presenter;

    private CreateTripSubpage2Fragment(CreateTripFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public static CreateTripSubpage2Fragment newInstance(CreateTripFragmentContract.Presenter presenter) {
        return new CreateTripSubpage2Fragment(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_trip_2, null);

        Button button_next = view.findViewById(R.id.button_next);
        button_next.setOnClickListener(v -> {
            presenter.clickNextOnSubpage2();
        });

        return view;
    }
}
package com.example.vandrabyapp.activities.main.pages.createtrip.subpages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.createtrip.CreateTripFragmentContract;
import com.example.vandrabyapp.activities.main.pages.createtrip.adapters.CreateTripPlacesAdapter;
import com.example.vandrabyapp.model.database.DataModel;

public class CreateTripSubpage1Fragment extends Fragment {

    CreateTripFragmentContract.Presenter presenter;

    private CreateTripSubpage1Fragment(CreateTripFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public static CreateTripSubpage1Fragment newInstance(CreateTripFragmentContract.Presenter presenter) {
        return new CreateTripSubpage1Fragment(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_trip_1, null);

        RecyclerView recyclerViewPlaces = view.findViewById(R.id.recycler_view_places);
        recyclerViewPlaces.setAdapter(new CreateTripPlacesAdapter(DataModel.getInstance().getUserLikedPlaces()));
        recyclerViewPlaces.setLayoutManager(new LinearLayoutManager(getContext()));

        Button button_next = view.findViewById(R.id.button_next);
        button_next.setOnClickListener(v -> {
            presenter.clickNextOnSubpage1();
        });

        return view;
    }
}
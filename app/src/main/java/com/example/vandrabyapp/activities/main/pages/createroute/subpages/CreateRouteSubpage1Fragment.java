package com.example.vandrabyapp.activities.main.pages.createroute.subpages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.createroute.adapters.CreateRoutePlacesAdapter;
import com.example.vandrabyapp.model.database.DataModel;

public class CreateRouteSubpage1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_route_1, null);

        RecyclerView recyclerViewPlaces = view.findViewById(R.id.recycler_view_places);
        recyclerViewPlaces.setAdapter(new CreateRoutePlacesAdapter(null, DataModel.getInstance().getUserLikedPlaces()));
        recyclerViewPlaces.setLayoutManager(new LinearLayoutManager(getContext()));

        Button button_next = view.findViewById(R.id.button_next);
        button_next.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_createRouteFragment1_to_createRouteFragment2);
        });

        return view;
    }
}
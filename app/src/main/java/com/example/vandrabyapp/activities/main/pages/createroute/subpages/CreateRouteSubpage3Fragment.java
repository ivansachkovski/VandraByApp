package com.example.vandrabyapp.activities.main.pages.createroute.subpages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.createroute.CreateRouteFragmentContract;

public class CreateRouteSubpage3Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_route_3, null);

        Button button_save_route = view.findViewById(R.id.button_save_route);
        button_save_route.setOnClickListener(v -> {
            //.clickSaveRoute();
            Navigation.findNavController(view).navigate(R.id.action_createRouteFragment3_to_profileFragment);
        });

        return view;
    }
}
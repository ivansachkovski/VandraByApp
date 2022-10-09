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

public class CreateRouteSubpage2Fragment extends Fragment {

    CreateRouteFragmentContract.Presenter presenter;

    public CreateRouteSubpage2Fragment() {

    }

    private CreateRouteSubpage2Fragment(CreateRouteFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public static CreateRouteSubpage2Fragment newInstance(CreateRouteFragmentContract.Presenter presenter) {
        return new CreateRouteSubpage2Fragment(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_route_2, null);

        Button button_next = view.findViewById(R.id.button_next);
        button_next.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_createRouteFragment2_to_createRouteFragment3);
        });

        return view;
    }
}
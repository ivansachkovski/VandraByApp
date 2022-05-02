package com.example.vandrabyapp.activities.main.pages.createroute.subpages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.createroute.CreateRouteFragmentContract;

public class CreateRouteSubpage2Fragment extends Fragment {

    CreateRouteFragmentContract.Presenter presenter;

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
            presenter.clickNextOnSubpage2();
        });

        return view;
    }
}
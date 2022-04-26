package com.example.vandrabyapp.activities.main.pages.createtrip;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.MainActivity;
import com.example.vandrabyapp.activities.main.pages.createtrip.subpages.CreateTripSubpage1Fragment;
import com.example.vandrabyapp.activities.main.pages.createtrip.subpages.CreateTripSubpage2Fragment;
import com.example.vandrabyapp.activities.main.pages.createtrip.subpages.CreateTripSubpage3Fragment;

public class CreateTripFragment extends Fragment implements CreateTripFragmentContract.View {

    private static final String CREATE_TRIP_SUBPAGE_1_FRAGMENT_TAG = "CreateTripSubpage1Fragment";
    private static final String CREATE_TRIP_SUBPAGE_2_FRAGMENT_TAG = "CreateTripSubpage2Fragment";
    private static final String CREATE_TRIP_SUBPAGE_3_FRAGMENT_TAG = "CreateTripSubpage3Fragment";

    CreateTripFragmentPresenter presenter;

    private CreateTripFragment() {
        presenter = new CreateTripFragmentPresenter(this);
    }

    public static CreateTripFragment newInstance() {
        return new CreateTripFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_create_trip, null);

        // Open start create trip page
        openSubpage1();

        return view;
    }

    private void loadFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_content, fragment, tag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void openSubpage1() {
        loadFragment(CreateTripSubpage1Fragment.newInstance(presenter), CREATE_TRIP_SUBPAGE_1_FRAGMENT_TAG);
    }

    @Override
    public void openSubpage2() {
        loadFragment(CreateTripSubpage2Fragment.newInstance(presenter), CREATE_TRIP_SUBPAGE_2_FRAGMENT_TAG);
    }

    @Override
    public void openSubpage3() {
        loadFragment(CreateTripSubpage3Fragment.newInstance(presenter), CREATE_TRIP_SUBPAGE_3_FRAGMENT_TAG);
    }

    @Override
    public void openSaveTripDialog() {
        // 1. Open Save Trip Dialog with 1 edit box and 1 button "Save"
        // 2. If user click "Save" - save trip and go to Profile page
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        mainActivity.openProfilePage();
    }
}
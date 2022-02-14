package com.example.vandrabyapp.activities.main.pages.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.swipes.photopager.SwipesPhotoFragment;
import com.example.vandrabyapp.model.entities.Place;

public class PlaceDetailsFragment extends Fragment {

    private final Place place;

    private PlaceDetailsFragment(Place place) {
        this.place = place;
    }

    public static PlaceDetailsFragment newInstance(Place place) {
        return new PlaceDetailsFragment(place);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_place_details, null);
        getActivity().invalidateOptionsMenu();

        Fragment fragment = SwipesPhotoFragment.newInstance(place.getPhotoUrls()); // todo::create new or create common class

        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_photo, fragment);
        fragmentTransaction.commit();

        TextView textPlaceName = view.findViewById(R.id.text_place_name);
        textPlaceName.setText(place.getName());

        TextView textPlaceLocation = view.findViewById(R.id.text_place_location);
        textPlaceLocation.setText(place.getFormattedLocation());

        TextView textPlaceDescription = view.findViewById(R.id.text_place_description);
        textPlaceDescription.setText(place.getDescription());

        String buildYearStr = Long.toString(place.getBuildYear());
        TextView textPlaceBuildYear = view.findViewById(R.id.text_place_build_year);
        textPlaceBuildYear.setText(buildYearStr);

        TextView textPlaceStyle = view.findViewById(R.id.text_place_style);
        textPlaceStyle.setText(place.getType()); // todo::change to style

        return view;
    }
}
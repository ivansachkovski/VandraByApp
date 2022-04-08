package com.example.vandrabyapp.activities.main.pages.details;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.swipes.photopager.SwipesPhotoFragment;
import com.example.vandrabyapp.model.entities.Place;

public class PlaceDetailsFragment extends Fragment {

    private final Place place;
    private final boolean shouldRate;

    private PlaceDetailsFragment(Place place, boolean shouldRate) {
        this.place = place;
        this.shouldRate = shouldRate;
    }

    public static PlaceDetailsFragment newInstance(Place place, boolean shouldRate) {
        return new PlaceDetailsFragment(place, shouldRate);
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

        if (!shouldRate) {
            // Hide buttons Like and Dislike
            LinearLayout layoutButtonsLikeAndDislike = view.findViewById(R.id.layout_buttons_like_dislike);
            layoutButtonsLikeAndDislike.setVisibility(View.INVISIBLE);
        }

        return view;
    }
}
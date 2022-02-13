package com.example.vandrabyapp.activities.main.pages.swipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.pages.swipes.photopager.SwipesPhotoFragment;
import com.example.vandrabyapp.model.entities.Place;

public class SwipesFragment extends Fragment implements SwipesFragmentContract.View {

    private final SwipesFragmentPresenter presenter;

    private CardView viewRoot;
    private TextView viewPlaceName;

    private SwipesFragment() {
        presenter = new SwipesFragmentPresenter(this);
    }

    public static SwipesFragment newInstance() {
        return new SwipesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main_swipes, null);

        viewRoot = view.findViewById(R.id.card_view);
        viewPlaceName = view.findViewById(R.id.sight_name);

        ImageView buttonLike = view.findViewById(R.id.btn_like);
        buttonLike.setOnClickListener(v -> {
            presenter.clickLikePlace();
        });

        ImageView buttonDislike = view.findViewById(R.id.btn_dislike);
        buttonDislike.setOnClickListener(v -> {
            presenter.clickDislikePlace();
        });

        ImageView buttonDetails = view.findViewById(R.id.btn_details);
        buttonDetails.setOnClickListener(v -> {
            presenter.clickOpenPlaceDetails();
        });

        presenter.invalidateScreen();

        return view;
    }

    @Override
    public void showPlaceToRate(Place place) {
        viewPlaceName.setText(place.getName());

        Fragment fragment = SwipesPhotoFragment.newInstance(place.getPhotoUrls());

        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.layout_photo, fragment);
        fragmentTransaction.commit();

        viewRoot.setVisibility(View.VISIBLE);
    }

    @Override
    public void showEmptyScreen() {
        viewRoot.setVisibility(View.INVISIBLE);
    }
}
package com.example.vandrabyapp.activities.main.pages.swipes;

import com.example.vandrabyapp.activities.main.MainActivity;
import com.example.vandrabyapp.model.database.DataModel;
import com.example.vandrabyapp.model.entities.Place;

public class SwipesFragmentPresenter implements SwipesFragmentContract.Presenter {

    private final SwipesFragmentContract.View view;
    private final SwipesFragmentContract.Model model;

    private final DataModel globalModel;

    public SwipesFragmentPresenter(SwipesFragmentContract.View view) {
        this.globalModel = DataModel.getInstance();
        this.view = view;
        this.model = new SwipesFragmentModel(globalModel.getUnratedPlaces());
    }

    @Override
    public void clickLikePlace() {
        Place place = model.getPlaceToRate();
        globalModel.markPlaceAsLiked(place.getId());

        model.swipe();
        invalidateScreen();
    }

    @Override
    public void clickDislikePlace() {
        Place place = model.getPlaceToRate();
        globalModel.markPlaceAsDisliked(place.getId());

        model.swipe();
        invalidateScreen();
    }

    @Override
    public void clickOpenPlaceDetails() {
        Place place = model.getPlaceToRate();

        SwipesFragment swipesFragment = (SwipesFragment) view;
        MainActivity mainActivity = (MainActivity) swipesFragment.getActivity();
        mainActivity.onOpenPlaceDetailsPage(place, true);
    }

    @Override
    public void invalidateScreen() {
        Place place = model.getPlaceToRate();
        if (place == null) {
            view.showEmptyScreen();
        } else {
            view.showPlaceToRate(place);
        }
    }
}

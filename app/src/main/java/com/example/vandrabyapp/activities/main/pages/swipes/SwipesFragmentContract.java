package com.example.vandrabyapp.activities.main.pages.swipes;

import com.example.vandrabyapp.model.entities.Place;

public interface SwipesFragmentContract {

    interface View {
        void showPlaceToRate(Place place);
        void showEmptyScreen();
    }

    interface Model {
        Place getPlaceToRate();
        void swipe();
    }

    interface Presenter {
        void clickLikePlace();
        void clickDislikePlace();
        void clickOpenPlaceDetails();

        void invalidateScreen();
    }
}
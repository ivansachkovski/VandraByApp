package com.example.vandrabyapp.activities.main.pages.createtrip;

import com.example.vandrabyapp.model.entities.Place;

public interface CreateTripFragmentContract {

    interface View {
        void openSubpage1();
        void openSubpage2();
        void openSubpage3();

        void openSaveTripDialog();
    }

    interface Model {
        void addPlace(Place place);
        void removePlace(Place place);
        void saveTrip();
    }

    interface Presenter {
        void clickNextOnSubpage1();
        void clickNextOnSubpage2();
        void clickSaveTrip();

        void addPlaceToTrip(Place place);
        void removePlaceFromTrip(Place place);
    }
}
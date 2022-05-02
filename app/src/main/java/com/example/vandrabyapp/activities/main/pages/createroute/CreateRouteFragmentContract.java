package com.example.vandrabyapp.activities.main.pages.createroute;

import com.example.vandrabyapp.model.entities.Place;

public interface CreateRouteFragmentContract {

    interface View {
        void openSubpage1();
        void openSubpage2();
        void openSubpage3();

        void openSaveRouteDialog();
    }

    interface Model {
        void addPlace(Place place);
        void removePlace(Place place);
        void saveRoute(String routeName);
    }

    interface Presenter {
        void clickNextOnSubpage1();
        void clickNextOnSubpage2();
        void clickSaveRoute();

        void addPlaceToRoute(Place place);
        void removePlaceFromRoute(Place place);
        void saveRoute(String routeName);
    }
}
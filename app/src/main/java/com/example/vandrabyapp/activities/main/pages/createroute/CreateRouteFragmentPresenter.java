package com.example.vandrabyapp.activities.main.pages.createroute;

import com.example.vandrabyapp.model.entities.Place;

public class CreateRouteFragmentPresenter implements CreateRouteFragmentContract.Presenter {

    private final CreateRouteFragmentContract.View view;
    private final CreateRouteFragmentContract.Model model;

    public CreateRouteFragmentPresenter(CreateRouteFragmentContract.View view) {
        this.view = view;
        this.model = new CreateRouteFragmentModel();
    }

    @Override
    public void clickNextOnSubpage1() {
        // todo::load data from the screen
        view.openSubpage2();
    }

    @Override
    public void clickNextOnSubpage2() {
        // todo::load data from the screen
        view.openSubpage3();
    }

    @Override
    public void clickSaveRoute() {
        // todo::load data from the screen
        model.saveRoute();
        view.openSaveRouteDialog();
    }

    @Override
    public void addPlaceToRoute(Place place) {
        model.addPlace(place);
    }

    @Override
    public void removePlaceFromRoute(Place place) {
        model.removePlace(place);
    }
}

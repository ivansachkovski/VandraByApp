package com.example.vandrabyapp.activities.main.pages.createtrip;

import com.example.vandrabyapp.model.database.DataModel;
import com.example.vandrabyapp.model.entities.Place;

public class CreateTripFragmentPresenter implements CreateTripFragmentContract.Presenter {

    private final CreateTripFragmentContract.View view;
    private final CreateTripFragmentContract.Model model;

    public CreateTripFragmentPresenter(CreateTripFragmentContract.View view) {
        this.view = view;
        this.model = new CreateTripFragmentModel();
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
    public void clickSaveTrip() {
        // todo::load data from the screen
        model.saveTrip();
        view.openSaveTripDialog();
    }

    @Override
    public void addPlaceToTrip(Place place) {
        model.addPlace(place);
    }

    @Override
    public void removePlaceFromTrip(Place place) {
        model.removePlace(place);
    }
}

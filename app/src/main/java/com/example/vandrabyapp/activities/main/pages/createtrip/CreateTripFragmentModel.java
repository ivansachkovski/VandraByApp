package com.example.vandrabyapp.activities.main.pages.createtrip;

import com.example.vandrabyapp.model.database.DataModel;
import com.example.vandrabyapp.model.entities.Place;
import com.example.vandrabyapp.model.entities.Trip;

import java.util.ArrayList;
import java.util.List;

public class CreateTripFragmentModel implements CreateTripFragmentContract.Model {

    private final List<Place> places;

    public CreateTripFragmentModel() {
        places = new ArrayList<>();
    }

    @Override
    public void addPlace(Place place) {
        places.add(place);
    }

    @Override
    public void removePlace(Place place) {
        places.remove(place);
    }

    @Override
    public void saveTrip() {
        // todo::choose trip id randomly
        Trip trip = new Trip(1, "Новый маршрут", places);

        DataModel model = DataModel.getInstance();
        model.addTrip(trip);
    }
}
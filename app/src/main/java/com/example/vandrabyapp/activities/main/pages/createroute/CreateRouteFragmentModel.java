package com.example.vandrabyapp.activities.main.pages.createroute;

import com.example.vandrabyapp.model.database.DataModel;
import com.example.vandrabyapp.model.entities.Place;
import com.example.vandrabyapp.model.entities.Route;

import java.util.ArrayList;
import java.util.List;

public class CreateRouteFragmentModel implements CreateRouteFragmentContract.Model {

    private final List<Place> places;

    public CreateRouteFragmentModel() {
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
    public void saveRoute(String routeName) {
        // todo::choose route id randomly
        Route route = new Route(1, routeName, places);

        DataModel model = DataModel.getInstance();
        model.addRoute(route);
    }
}
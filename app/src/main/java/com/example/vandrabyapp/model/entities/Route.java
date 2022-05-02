package com.example.vandrabyapp.model.entities;

import java.util.List;

public class Route {

    // Unique identifier of the route
    private long id;

    // Name of the route
    private final String name;

    // Places that make up the route
    private final List<Place> places;

    public Route(long id, String name, List<Place> places) {
        this.id = id;
        this.name = name;
        this.places = places;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public String getName() {
        return name;
    }
}

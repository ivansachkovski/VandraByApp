package com.example.vandrabyapp.model.entities;

import java.util.List;

public class Trip {

    private long id;

    private final String name;

    private final List<Place> places;

    public Trip(long id, String name, List<Place> places) {
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

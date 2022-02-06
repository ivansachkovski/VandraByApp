package com.example.vandrabyapp.model.database;

import com.example.vandrabyapp.model.entities.Place;
import com.example.vandrabyapp.model.entities.User;

import java.util.List;

public abstract class DataModel {

    static DataModel instance;

    public static DataModel getInstance() {
        if (instance == null) {
            instance = new DataModelMock(); // todo::change to actual db helper implementation
        }
        return instance;
    }

    public abstract void init();

    public abstract User getUser();

    public abstract List<Place> getUnratedPlaces();

    public abstract List<Place> getUserLikedPlaces();

    public abstract List<Place> getUserVisitedPlaces();
}
package com.example.vandrabyapp.model.database;

import com.example.vandrabyapp.model.entities.Place;
import com.example.vandrabyapp.model.entities.User;

import java.util.ArrayList;
import java.util.List;

public class DataModelMock extends DataModel {

    private User user;
    private List<Place> places;

    @Override
    public void init() {
        initUser();
        initPlaces();
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public List<Place> getUnratedPlaces() {
        return places;
    }

    @Override
    public List<Place> getUserLikedPlaces() {
        return places;
    }

    @Override
    public List<Place> getUserVisitedPlaces() {
        return places;
    }

    private void initUser() {
        user = new User();
        user.setName("Временный пользователь");
        user.setNickname("ABOBA");
    }

    private void initPlaces() {
        places = new ArrayList<>();
    }
}
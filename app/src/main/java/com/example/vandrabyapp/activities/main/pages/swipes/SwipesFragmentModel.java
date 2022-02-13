package com.example.vandrabyapp.activities.main.pages.swipes;

import com.example.vandrabyapp.model.entities.Place;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SwipesFragmentModel implements SwipesFragmentContract.Model {

    Queue<Place> places = new LinkedList<>();

    public SwipesFragmentModel(List<Place> places) {
        this.places.addAll(places);
    }

    @Override
    public Place getPlaceToRate() {
        return places.peek();
    }

    @Override
    public void swipe() {
        places.poll();
    }
}
package com.example.vandrabyapp.model.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    // todo::understand required fields
    private long id;

    private String name;
    private String nickname; // todo::change to email?

    private String photoUrl;

    private final List<Long> likedPlacesIds = new ArrayList<>();
    private final List<Long> dislikedPlacesIds = new ArrayList<>();
    private final List<Long> visitedPlacesIds = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public List<Long> getLikedPlacesIds() {
        return likedPlacesIds;
    }

    public List<Long> getDislikedPlaces() {
        return dislikedPlacesIds;
    }

    public List<Long> getVisitedPlacesIds() {
        return visitedPlacesIds;
    }

    public void addLikedPlace(long id) {
        likedPlacesIds.add(id);
    }

    public void addDislikedPlace(long id) {
        dislikedPlacesIds.add(id);
    }

    public void addVisitedPlace(long id) {
        visitedPlacesIds.add(id);
    }

    public boolean isPlaceLiked(long placeId) {
        return likedPlacesIds.contains(placeId);
    }

    public boolean isPlaceDisliked(long placeId) {
        return dislikedPlacesIds.contains(placeId);
    }

    public boolean isPlaceVisited(long placeId) {
        return visitedPlacesIds.contains(placeId);
    }
}
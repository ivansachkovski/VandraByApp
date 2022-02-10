package com.example.vandrabyapp.model.entities;

import java.util.List;

public class Place {

    private final long id;

    private final String name;
    private final String description;
    private final String type;
    private final long buildYear;

    private final List<String> photoUrls;

    private final String locationRegion;
    private final String locationDistrict;
    private final String locationLocalityType;
    private final String locationLocalityName;

    public Place(long id, String name, String description, String type, long buildYear,
                 List<String> photoUrls, String locationRegion, String locationDistrict,
                 String locationLocalityType, String locationLocalityName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.buildYear = buildYear;
        this.photoUrls = photoUrls;
        this.locationRegion = locationRegion;
        this.locationDistrict = locationDistrict;
        this.locationLocalityType = locationLocalityType;
        this.locationLocalityName = locationLocalityName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public long getBuildYear() {
        return buildYear;
    }

    public String getLocationRegion() {
        return locationRegion;
    }

    public String getLocationDistrict() {
        return locationDistrict;
    }

    public String getLocationLocalityType() {
        return locationLocalityType;
    }

    public String getLocationLocalityName() {
        return locationLocalityName;
    }

    public String getFormattedLocation() {
        return String.format("%s %s, %s р-н, %s обл.", locationLocalityType, locationLocalityName, locationDistrict, locationRegion);
    }
}
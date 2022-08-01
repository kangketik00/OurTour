package com.makmurjaya.ourtour.models;
// Tanggal Pengerjaan: 23-07-2022
// Ilham Zaki - 10119006 - IF1
public class ModelTour {
    private String imgurl;
    private String title;
    private String location;
    private String rating;
    private String description;
    private String latitude;
    private String longitude;
    private String key;

    public ModelTour(){

    }

    public ModelTour(String imgurl, String title, String location, String rating, String description, String latitude, String longitude) {
        this.imgurl = imgurl;
        this.title = title;
        this.location = location;
        this.rating = rating;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

package com.example.androidjava.lesson_11_movies;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("years")
    private int years;
    @SerializedName("poster")
    private Poster poster;
    @SerializedName("rating")
    private Rating rating;


    public Movie(Rating rating, Poster poster, int years, String description, String name, int id) {
        this.rating = rating;
        this.poster = poster;
        this.years = years;
        this.description = description;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getYears() {
        return years;
    }

    public Poster getPoster() {
        return poster;
    }

    public Rating getRating() {
        return rating;
    }
}

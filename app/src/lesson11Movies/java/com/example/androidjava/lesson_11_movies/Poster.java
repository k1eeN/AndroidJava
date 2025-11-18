package com.example.androidjava.lesson_11_movies;

import com.google.gson.annotations.SerializedName;

public class Poster {
    @SerializedName("url")
    private String url;

    public Poster() {

    }

    public Poster(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Poster{" +
                "url='" + url + '\'' +
                '}';
    }
}

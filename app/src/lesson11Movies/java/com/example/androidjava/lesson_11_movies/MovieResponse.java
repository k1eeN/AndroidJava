package com.example.androidjava.lesson_11_movies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MovieResponse {

    @SerializedName("docs")
    private List<Movie> movies;

    public MovieResponse(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        List<Movie> result = new ArrayList<>();

        for (Movie movie : movies) {
            String kp = movie.getRating().getKp();
            if (kp != null && !kp.isEmpty()) {
                double value = Double.parseDouble(kp);
                String formatted = String.format(java.util.Locale.US, "%.1f", value);
                movie.getRating().setKp(formatted);
            }
            result.add(movie);
        }

        return result;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movies=" + movies +
                '}';
    }
}

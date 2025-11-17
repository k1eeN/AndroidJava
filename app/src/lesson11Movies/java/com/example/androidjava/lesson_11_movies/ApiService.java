package com.example.androidjava.lesson_11_movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("movie?token=FSRACQ8-TSBMBAA-P03CX4H-K82QBTW&rating.kp=8-10&limit=20")
    Single<MovieResponse> loadMovies();
}

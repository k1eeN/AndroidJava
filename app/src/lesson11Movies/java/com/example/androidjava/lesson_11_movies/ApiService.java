package com.example.androidjava.lesson_11_movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie?token=FSRACQ8-TSBMBAA-P03CX4H-K82QBTW&rating.kp=7-10&sortField=votes.kp&sortType=-1&limit=30")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie/{movieId}?token=FSRACQ8-TSBMBAA-P03CX4H-K82QBTW")
    Single<TrailerResponse> loadTrailers(@Path("movieId") int movieId);

    @GET("review?token=FSRACQ8-TSBMBAA-P03CX4H-K82QBTW")
    Single<ReviewResponse> loadReviews(@Query("movieId") int movieId);
}

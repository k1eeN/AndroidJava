package com.example.androidjava.lesson_10_working_with_internet;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("random")
    Single<DogImage> loadDogImage();
}

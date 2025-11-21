package com.example.androidjava.lesson_11_movies;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class FavouriteMovieViewModel extends AndroidViewModel {

    private final MovieDao movieDao;
    public FavouriteMovieViewModel(@NonNull Application application) {
        super(application);
        movieDao = MovieDatabase.getInstance(application).movieDao();
    }

    public LiveData<List<Movie>> getMovies() {
        return movieDao.getAllFavouriteMovies();
    }
}

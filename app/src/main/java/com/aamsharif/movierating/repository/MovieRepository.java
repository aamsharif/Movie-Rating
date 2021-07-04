package com.aamsharif.movierating.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aamsharif.movierating.models.MovieModel;
import com.aamsharif.movierating.request.MovieApiClient;

import java.util.List;

public class MovieRepository {
    private MovieApiClient movieApiClient;
    private static MovieRepository sInstance;

    public static MovieRepository getInstance(){
        if(sInstance == null){
            sInstance = new MovieRepository();
        }
        return sInstance;
    }

    private MovieRepository(){
        movieApiClient  = MovieApiClient.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies(){
        return movieApiClient.getMovies();
    }
}

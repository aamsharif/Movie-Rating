package com.aamsharif.movierating.request;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.aamsharif.movierating.models.MovieModel;

import java.util.List;

public class MovieApiClient {
    private static MutableLiveData<List<MovieModel>> movies;
    private static MovieApiClient movieApiClient;

    private MovieApiClient(){
        movies = new MutableLiveData<>();
    }

    public static MovieApiClient getInstance(){
        if(movieApiClient == null){
            movieApiClient = new MovieApiClient();
        }
        return movieApiClient;
    }

    public LiveData<List<MovieModel>> getMovies(){
        return movies;
    }
}

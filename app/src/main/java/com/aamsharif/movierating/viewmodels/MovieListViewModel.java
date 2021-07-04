package com.aamsharif.movierating.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aamsharif.movierating.models.MovieModel;
import com.aamsharif.movierating.repository.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {
    private MovieRepository repository;


    public MovieListViewModel() {
        repository = MovieRepository.getInstance();
    }

    public LiveData<List<MovieModel>> getMovies() {

        return repository.getMovies();
    }
}

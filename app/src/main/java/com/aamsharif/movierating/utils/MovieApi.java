package com.aamsharif.movierating.utils;

import com.aamsharif.movierating.models.MovieModel;
import com.aamsharif.movierating.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    //  https://api.themoviedb.org/3/search/movie?api_key=3898856caec208a7855713dbe2e89d32&query=Jack+Reacher&page=1

    @GET("3/search/movie")
    Call<MovieSearchResponse> searchMovies(@Query("api_key") String key,
                                           @Query("query") String query,
                                           @Query("page") String page);

    //  https://api.themoviedb.org/3/movie/550?api_key=3898856caec208a7855713dbe2e89d32
    @GET("3/movie/{id}")
    Call<MovieModel> getMovie(@Path("id") int id,
                              @Query("api_key") String key);
}

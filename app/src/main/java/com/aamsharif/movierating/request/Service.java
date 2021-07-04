package com.aamsharif.movierating.request;

import com.aamsharif.movierating.utils.Credentials;
import com.aamsharif.movierating.utils.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    private static MovieApi sMovieApi;

    public static MovieApi getMovieApi(){
        if(sMovieApi == null){
            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(Credentials.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = retrofitBuilder.build();
            sMovieApi = retrofit.create(MovieApi.class);
        }
        return sMovieApi;
    }
}

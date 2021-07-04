package com.aamsharif.movierating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.aamsharif.movierating.models.MovieModel;
import com.aamsharif.movierating.request.Service;
import com.aamsharif.movierating.response.MovieSearchResponse;
import com.aamsharif.movierating.utils.Credentials;
import com.aamsharif.movierating.utils.MovieApi;
import com.aamsharif.movierating.viewmodels.MovieListViewModel;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {
    private static final String TAG = "MovieListActivity";

    Button button;

    MovieListViewModel mMovieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getRetrofitResponseById();
//            }
//        });

        mMovieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
    }

    private void getRetrofitResponse() {
        MovieApi movieApi = Service.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi.searchMovies(Credentials.API_KEY,
                "Action", "1");

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200){
//                    Log.e(TAG, "onResponse: 200 1" + response.body().toString());
                    List<MovieModel> movies = response.body().getResults();
                    for(MovieModel movie :movies){
                        Log.e(TAG, "onResponse: 200 " + movie.getTitle());
                    }
                } else {

                    try {
                        Log.e(TAG, "onResponse: else1" + response.errorBody().string());
                    } catch (IOException e) {
                        Log.e(TAG, "onResponse: else2", e);
                    }


                }
            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }

    private void getRetrofitResponseById() {
        Service.getMovieApi()
                .getMovie(343611, Credentials.API_KEY)
                .enqueue(new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        if(response.code() == 200){
                            Log.e(TAG, "onResponse: " + response.body().getTitle());
                        } else {
                            try {
                                Log.e(TAG, "onResponse: " + response.errorBody().string());
                            } catch (IOException e) {
                                Log.e(TAG, "onResponse: ", e);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {
                        Log.e(TAG, "onFailure: ", t);
                    }
                });
    }
}
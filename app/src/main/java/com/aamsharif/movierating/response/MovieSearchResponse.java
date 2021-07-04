package com.aamsharif.movierating.response;

import java.util.List;

import com.aamsharif.movierating.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MovieSearchResponse {

    @SerializedName("results")
    @Expose
    private List<MovieModel> results = null;

    @SerializedName("total_results")
    @Expose
    private int totalResults;

    public List<MovieModel> getResults() {
        return results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "results=" + results +
                ", totalResults=" + totalResults +
                '}';
    }
}

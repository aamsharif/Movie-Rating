package com.aamsharif.movierating.models;


import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MovieModel implements Parcelable {

    @SerializedName("movie_id")
    @Expose
    private int movieId;

    @SerializedName("movie_overview")
    @Expose
    private String movieOverview;

    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("vote_average")
    @Expose
    private double voteAverage;

    public final static Creator<MovieModel> CREATOR = new Creator<MovieModel>() {


        @SuppressWarnings({"unchecked"})
        public MovieModel createFromParcel(android.os.Parcel in) {
            return new MovieModel(in);
        }

        public MovieModel[] newArray(int size) {
            return (new MovieModel[size]);
        }

    };

    protected MovieModel(android.os.Parcel in) {
        this.movieId = ((int) in.readValue((int.class.getClassLoader())));
        this.movieOverview = ((String) in.readValue((String.class.getClassLoader())));
        this.posterPath = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.voteAverage = ((double) in.readValue((double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public MovieModel() {
    }

    /**
     *
     * @param voteAverage
     * @param movieOverview
     * @param releaseDate
     * @param movieId
     * @param title
     * @param posterPath
     */
    public MovieModel(int movieId, String movieOverview, String posterPath, String releaseDate, String title, double voteAverage) {
        super();
        this.movieId = movieId;
        this.movieOverview = movieOverview;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.voteAverage = voteAverage;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(movieId);
        dest.writeValue(movieOverview);
        dest.writeValue(posterPath);
        dest.writeValue(releaseDate);
        dest.writeValue(title);
        dest.writeValue(voteAverage);
    }

    public int describeContents() {
        return 0;
    }
}
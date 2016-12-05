package com.movieapp.monica.whichtowatch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieObject {
    @SerializedName("poster_path")
    private String moviePosterPath;
    
    @SerializedName("adult")
    private boolean movieIsAdult;
    
    @SerializedName("overview")
    private String movieOverview;

    @SerializedName("release_date")
    private String movieReleaseDate;

    @SerializedName("genre_ids")
    private List<Integer> movieGenreIds;

    @SerializedName("id")
    private Integer movieId;

    @SerializedName("original_title")
    private String movieOriginalTitle;

    @SerializedName("original_language")
    private String movieOriginalLanguage;

    @SerializedName("title")
    private String movieTitle;

    @SerializedName("backdrop_path")
    private String movieBackdropPath;

    @SerializedName("popularity")
    private Double moviePopularity;

    @SerializedName("vote_count")
    private Integer movieVoteCount;

    @SerializedName("video")
    private boolean movieIsVideo;

    @SerializedName("vote_average")
    private Double movieVoteAverage;

    @SerializedName("runtime")
    private int runtime;
    
    public String getMoviePosterPath() {
        return moviePosterPath;
    }

    public void setMoviePosterPath(String moviePosterPath) {
        this.moviePosterPath = moviePosterPath;
    }

    public boolean isMovieIsAdult() {
        return movieIsAdult;
    }

    public void setMovieIsAdult(boolean movieIsAdult) {
        this.movieIsAdult = movieIsAdult;
    }

    public String getMovieOverview() {
        return movieOverview;
    }

    public void setMovieOverview(String movieOverview) {
        this.movieOverview = movieOverview;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public List<Integer> getMovieGenreIds() {
        return movieGenreIds;
    }

    public void setMovieGenreIds(List<Integer> movieGenreIds) {
        this.movieGenreIds = movieGenreIds;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieOriginalTitle() {
        return movieOriginalTitle;
    }

    public void setMovieOriginalTitle(String movieOriginalTitle) {
        this.movieOriginalTitle = movieOriginalTitle;
    }

    public String getMovieOriginalLanguage() {
        return movieOriginalLanguage;
    }

    public void setMovieOriginalLanguage(String movieOriginalLanguage) {
        this.movieOriginalLanguage = movieOriginalLanguage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieBackdropPath() {
        return movieBackdropPath;
    }

    public void setMovieBackdropPath(String movieBackdropPath) {
        this.movieBackdropPath = movieBackdropPath;
    }

    public Double getMoviePopularity() {
        return moviePopularity;
    }

    public void setMoviePopularity(Double moviePopularity) {
        this.moviePopularity = moviePopularity;
    }

    public Integer getMovieVoteCount() {
        return movieVoteCount;
    }

    public void setMovieVoteCount(Integer movieVoteCount) {
        this.movieVoteCount = movieVoteCount;
    }

    public boolean isMovieIsVideo() {
        return movieIsVideo;
    }

    public void setMovieIsVideo(boolean movieIsVideo) {
        this.movieIsVideo = movieIsVideo;
    }

    public Double getMovieVoteAverage() {
        return movieVoteAverage;
    }

    public void setMovieVoteAverage(Double movieVoteAverage) {
        this.movieVoteAverage = movieVoteAverage;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }
}
package com.movieapp.monica.whichtowatch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieInterfaces {
    @GET("movie/{sortBy}")
    Call<MovieData> getMoviesBySort(@Path("sortBy") String sortBy, @Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MovieData> getMoviesById(@Path("id") int id, @Query("api_key") String apiKey);
}
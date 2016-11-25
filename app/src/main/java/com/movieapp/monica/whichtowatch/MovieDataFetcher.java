package com.movieapp.monica.whichtowatch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDataFetcher {
    Retrofit theFetcher;
    final String BASE_URL = "https://api.themoviedb.org/3/";

    public MovieDataFetcher() {
        theFetcher = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    public Retrofit getFetcher() {
        return theFetcher;
    }
}

package com.movieapp.monica.whichtowatch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieReviewObject
{
    @SerializedName("id")
    private String dataIdMovie;

    @SerializedName("author")
    private String dataAuthor;

    @SerializedName("content")
    private String dataContent;

    @SerializedName("url")
    private String dataUrl;


    public String getDataIdMovie() {
        return dataIdMovie;
    }

    public void setDataIdMovie(String dataIdMovie) {
        this.dataIdMovie = dataIdMovie;
    }

    public String getDataAuthor() {
        return dataAuthor;
    }

    public void setDataAuthor(String dataAuthor) {
        this.dataAuthor = dataAuthor;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }
}
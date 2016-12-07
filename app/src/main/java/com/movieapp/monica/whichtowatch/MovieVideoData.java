package com.movieapp.monica.whichtowatch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieVideoData {
    @SerializedName("id")
    private Integer dataId;

    @SerializedName("results")
    private List<MovieVideoObject> dataResult;


    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public List<MovieVideoObject> getDataResult() {
        return dataResult;
    }

    public void setDataResult(List<MovieVideoObject> dataResult) {
        this.dataResult = dataResult;
    }
}
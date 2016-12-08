package com.movieapp.monica.whichtowatch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieReviewData {
    @SerializedName("id")
    private Integer dataId;

    @SerializedName("page")
    private Integer dataPage;

    @SerializedName("total_pages")
    private Integer dataTotalPages;

    @SerializedName("total_results")
    private Integer dataTotalResults;

    //TODO change SerializedName from result to results
    @SerializedName("results")
    private List<MovieReviewObject> dataResult;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getDataPage() {
        return dataPage;
    }

    public void setDataPage(Integer dataPage) {
        this.dataPage = dataPage;
    }

    public List<MovieReviewObject> getDataResult() {
        return dataResult;
    }

    public void setDataResult(List<MovieReviewObject> dataResult) {
        this.dataResult = dataResult;
    }

    public Integer getDataTotalPages() {
        return dataTotalPages;
    }

    public void setDataTotalPages(Integer dataTotalPages) {
        this.dataTotalPages = dataTotalPages;
    }

    public Integer getDataTotalResults() {
        return dataTotalResults;
    }

    public void setDataTotalResults(Integer dataTotalResults) {
        this.dataTotalResults = dataTotalResults;
    }
}
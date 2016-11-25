package com.movieapp.monica.whichtowatch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieData {
    @SerializedName("page")
    private Integer dataPage;

    @SerializedName("results")
    private List<MovieObject> dataResults;

    @SerializedName("total_results")
    private Integer dataTotalResults;

    @SerializedName("total_pages")
    private Integer dataTotalPages;

    public Integer getDataPage() {
        return dataPage;
    }

    public void setDataPage(Integer dataPage) {
        this.dataPage = dataPage;
    }

    public List<MovieObject> getDataResults() {
        return dataResults;
    }

    public void setDataResults(List<MovieObject> dataResults) {
        this.dataResults = dataResults;
    }

    public Integer getDataTotalResults() {
        return dataTotalResults;
    }

    public void setDataTotalResults(Integer dataTotalResults) {
        this.dataTotalResults = dataTotalResults;
    }

    public Integer getDataTotalPages() {
        return dataTotalPages;
    }

    public void setDataTotalPages(Integer dataTotalPages) {
        this.dataTotalPages = dataTotalPages;
    }
}
package com.amrit.redditchallengeapp.Model;

import com.amrit.redditchallengeapp.Model.Children.Data.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amrit on 2/22/2018.
 */

// Model to get the json feed of the listing
public class RedditResponse {
    @SerializedName("data")
    @Expose
    private DataResponse dataResponse;

    public DataResponse getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(DataResponse dataResponse) {
        this.dataResponse = dataResponse;
    }

    @Override
    public String toString() {
        return "RedditResponse{" +
                "dataResponse=" + dataResponse +
                '}';
    }
}

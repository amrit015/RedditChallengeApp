package com.amrit.redditchallengeapp.Model;

import com.amrit.redditchallengeapp.Model.Children.Children;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amrit on 2/22/2018.
 */

public class DataResponse {
    @SerializedName("after")
    @Expose
    private String nextPage;

    @SerializedName("children")
    @Expose
    private List<Children> children;

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "nextPage='" + nextPage + '\'' +
                ", children=" + children +
                '}';
    }
}

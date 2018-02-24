package com.amrit.redditchallengeapp.Model.Children;

import com.amrit.redditchallengeapp.Model.Children.Data.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amrit on 2/22/2018.
 */

public class Children {
    @SerializedName("data")
    @Expose
    private Data dataList;

    public Data getDataList() {
        return dataList;
    }

    public void setDataList(Data dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "Children{" +
                "dataList=" + dataList +
                '}';
    }
}

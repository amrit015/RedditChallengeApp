package com.amrit.redditchallengeapp.Model.Children.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amrit on 2/22/2018.
 */

public class Data {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("permalink")
    @Expose
    private String permalink;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @Override
    public String toString() {
        return "Data{" +
                "title='" + title + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", permalink='" + permalink + '\'' +
                '}';
    }
}

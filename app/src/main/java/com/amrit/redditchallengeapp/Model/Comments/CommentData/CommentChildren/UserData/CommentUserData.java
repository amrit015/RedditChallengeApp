package com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.UserData;

import com.amrit.redditchallengeapp.Model.Children.Data.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amrit on 2/23/2018.
 */

public class CommentUserData {

    @SerializedName("body")
    @Expose
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommentUserData{" +
                "body='" + body + '\'' +
                '}';
    }
}

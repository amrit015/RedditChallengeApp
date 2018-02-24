package com.amrit.redditchallengeapp.Model.Comments;

import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amrit on 2/22/2018.
 */

// Model class to get the json feed of the comments
public class CommentsResponse {

    @SerializedName("data")
    @Expose
    private CommentData commentData;

    public CommentData getCommentData() {
        return commentData;
    }

    public void setCommentData(CommentData commentData) {
        this.commentData = commentData;
    }

    @Override
    public String toString() {
        return "CommentsResponse{" +
                "commentData=" + commentData +
                '}';
    }
}

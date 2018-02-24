package com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren;

import com.amrit.redditchallengeapp.Model.Children.Data.Data;
import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.UserData.CommentUserData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amrit on 2/23/2018.
 */

public class CommentChildren {
    @SerializedName("data")
    @Expose
    private CommentUserData commentList;


    public CommentUserData getCommentList() {
        return commentList;
    }

    public void setCommentList(CommentUserData commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "CommentChildren{" +
                "commentList=" + commentList +
                '}';
    }
}

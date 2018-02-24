package com.amrit.redditchallengeapp.Model.Comments.CommentData;

import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.CommentChildren;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amrit on 2/23/2018.
 */

public class CommentData {
    @SerializedName("children")
    @Expose
    private List<CommentChildren> commentChildren;

    public List<CommentChildren> getCommentChildren() {
        return commentChildren;
    }

    public void setCommentChildren(List<CommentChildren> commentChildren) {
        this.commentChildren = commentChildren;
    }

    @Override
    public String toString() {
        return "CommentData{" +
                "commentChildren=" + commentChildren +
                '}';
    }
}

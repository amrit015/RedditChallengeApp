package com.amrit.redditchallengeapp;

import android.content.Context;

import com.amrit.redditchallengeapp.Model.Children.Children;
import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.CommentChildren;

import java.util.List;

/**
 * Created by Amrit on 2/22/2018.
 */

// interfaces for the presenter, views and listeners for callbacks
public interface GetResponse {

    interface Presenter {
        void getDataFromUrl(Context context, String pageId);
    }

    interface ListingFeedCall {
        void initListingCall(Context context, String url);
    }

    interface ListingCallListener {
        void onSuccess(String msg, List<Children> data, String nextPage);
        void onFailure(String msg);
    }

    interface ListingActivityView {
        void onGetSuccess(String msg, List<Children> data, String nextPage);
        void onGetFailure(String msg);
    }

    interface PresenterComment {
        void getDataFromUrl(Context context, String url);
    }

    interface CommentFeedCall {
        void initCommentCall(Context context, String url);
    }

    interface CommentsActivityView {
        void onGetSuccess(String msg, List<CommentChildren> commentList);
        void onGetFailure(String msg);
    }

    interface CommentCallListener {
        void onSuccess(String msg, List<CommentChildren> commentChildren);
        void onFailure(String msg);
    }

}

package com.amrit.redditchallengeapp.Presenter;

import android.content.Context;

import com.amrit.redditchallengeapp.GetResponse;
import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.CommentChildren;
import com.amrit.redditchallengeapp.RequestCall;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by Amrit on 2/23/2018.
 */

// Presenter for the CommentActivity
public class CommentPresenter implements GetResponse.PresenterComment, GetResponse.CommentCallListener {

    GetResponse.CommentsActivityView view;
    RequestCall requestCall;

    public CommentPresenter(GetResponse.CommentsActivityView view) {
        this.view = view;
        requestCall = new RequestCall(this);
    }

    @Override
    public void getDataFromUrl(Context context, String url) {
        requestCall.initCommentCall(context, url);
    }

    @Override
    public void onSuccess(String msg, List<CommentChildren> commentChildren) {
        view.onGetSuccess(msg, commentChildren);
    }

    @Override
    public void onFailure(String msg) {
        view.onGetFailure(msg);
    }
}

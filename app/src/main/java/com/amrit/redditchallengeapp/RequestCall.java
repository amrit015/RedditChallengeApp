package com.amrit.redditchallengeapp;

import android.content.Context;
import android.util.Log;

import com.amrit.redditchallengeapp.Model.Children.Children;
import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.CommentChildren;
import com.amrit.redditchallengeapp.Model.Comments.CommentsResponse;
import com.amrit.redditchallengeapp.Model.DataResponse;
import com.amrit.redditchallengeapp.Model.RedditResponse;
import com.amrit.redditchallengeapp.Presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Amrit on 2/23/2018.
 */

// fetch the json feeds and pass the list to the view through the presenter
public class RequestCall implements GetResponse.ListingFeedCall, GetResponse.CommentFeedCall{

    private String TAG = "RequestCall";
    List<Children> resultList = new ArrayList<>();
    List<CommentChildren> commentList = new ArrayList<>();
    private GetResponse.ListingCallListener listingCallListener;
    private GetResponse.CommentCallListener commentCallListener;

    String nextPage;

    public RequestCall(GetResponse.ListingCallListener listingCallListener) {
        this.listingCallListener = listingCallListener;
    }

    public RequestCall(GetResponse.CommentCallListener commentCallListener) {
        this.commentCallListener = commentCallListener;
    }

    // fetching the top listings and using the listener for callback to the view on success
    @Override
    public void initListingCall(Context context, String pageId) {
        // initializing the interface, attaching endpoints and creating retrofit builder for the service
        FeedAPI feedAPI = ApiClient.getResponse().create(FeedAPI.class);
        Call<RedditResponse> response = feedAPI.getListing(pageId);
        Log.i(TAG, "Call: " + response.request());
        response.enqueue(new Callback<RedditResponse>() {
            @Override
            public void onResponse(Call<RedditResponse> call, Response<RedditResponse> response) {
                nextPage = response.body().getDataResponse().getNextPage();
                resultList = response.body().getDataResponse().getChildren();
                listingCallListener.onSuccess("Success", resultList, nextPage);
            }

            @Override
            public void onFailure(Call<RedditResponse> call, Throwable t) {
                listingCallListener.onFailure(t.toString());
            }
        });
    }

    // fetching the comments
    @Override
    public void initCommentCall(Context context, String url) {

        // initializing the interface, attaching endpoints and creating retrofit builder for the service
        FeedAPI feedAPI = ApiClient.getResponse().create(FeedAPI.class);
        Call<List<CommentsResponse>> response = feedAPI.getComments(url);
        Log.i(TAG, "Call: " + response.request());

        response.enqueue(new Callback<List<CommentsResponse>>() {
            @Override
            public void onResponse(Call<List<CommentsResponse>> call, Response<List<CommentsResponse>> response) {
                Log.i(TAG, "Response: " + response.toString());
                commentList = response.body().get(1).getCommentData().getCommentChildren();
                Log.i(TAG, "Response: " + commentList.toString());
                commentCallListener.onSuccess("Success", commentList);
            }

            @Override
            public void onFailure(Call<List<CommentsResponse>> call, Throwable t) {
                commentCallListener.onFailure(t.toString());
            }
        });

    }
}

package com.amrit.redditchallengeapp;

import com.amrit.redditchallengeapp.Model.Comments.CommentsResponse;
import com.amrit.redditchallengeapp.Model.DataResponse;
import com.amrit.redditchallengeapp.Model.RedditResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Amrit on 2/22/2018.
 */

// Retrofit calls for listing and comments
public interface FeedAPI {

    @GET("/r/all/top.json")
    Call<RedditResponse> getListing(@Query("after") String pageId);

    @GET
    Call<List<CommentsResponse>> getComments(@Url String url);
}
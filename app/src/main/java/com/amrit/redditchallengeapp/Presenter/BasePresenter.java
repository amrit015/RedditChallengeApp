package com.amrit.redditchallengeapp.Presenter;

import android.content.Context;

import com.amrit.redditchallengeapp.GetResponse;
import com.amrit.redditchallengeapp.Model.Children.Children;
import com.amrit.redditchallengeapp.RequestCall;
import com.amrit.redditchallengeapp.View.ListingActivity;

import java.util.List;

/**
 * Created by Amrit on 2/23/2018.
 */

// Presenter for the ListingActivity, presenter is the mediator between the model and view
public class BasePresenter implements GetResponse.Presenter,GetResponse.ListingCallListener{

    private GetResponse.ListingActivityView view;
    private RequestCall requestCall;

    public BasePresenter(){}

    public BasePresenter(GetResponse.ListingActivityView view) {
        this.view = view;
        requestCall = new RequestCall(this);
    }


    @Override
    public void getDataFromUrl(Context context, String url) {
        requestCall.initListingCall(context,url);
    }

    @Override
    public void onSuccess(String msg, List<Children> data, String nextPage) {
        view.onGetSuccess(msg, data, nextPage);
    }

    @Override
    public void onFailure(String msg) {
        view.onGetFailure(msg);
    }
}

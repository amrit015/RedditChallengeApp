package com.amrit.redditchallengeapp.View;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.amrit.redditchallengeapp.Adapter.CustomAdapter;
import com.amrit.redditchallengeapp.EndlessRecyclerViewScrollListener;
import com.amrit.redditchallengeapp.GetResponse;
import com.amrit.redditchallengeapp.Model.Children.Children;
import com.amrit.redditchallengeapp.Presenter.BasePresenter;
import com.amrit.redditchallengeapp.R;

import java.util.ArrayList;
import java.util.List;

// Main Activity, entry point to the application
// Here, the listing from the reddit is fetched and displayed in recyclerview
// Presenter only tells the activity what to display
public class ListingActivity extends AppCompatActivity implements GetResponse.ListingActivityView {

    private String TAG = "ListingActivity";
    private BasePresenter presenter;
    private RecyclerView recyclerView;
    public RecyclerView.LayoutManager mLayoutManager;
    Context context;
    String nextPageId;

    //    private String url = "https://www.reddit.com/r/all/top.json";
    List<Children> list = new ArrayList<>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        // presenter for the activity
        presenter = new BasePresenter(this);
        // getting data, onGetSuccess is called after receiving data
        presenter.getDataFromUrl(getApplicationContext(), "");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);
        // binding view to the adapter
        adapter = new CustomAdapter(this, list, R.layout.adapter_custom);
        // adding scroll on recyclerview for pagination
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager) mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                // putting a delay of 1 sec
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        presenter.getDataFromUrl(getApplicationContext(), nextPageId);
                    }
                }, 1000);
                //getting total items number of the recyclerView and notifying adapter of the new inserted items only below in LoadMore
                Log.i(TAG, "Pagination");
            }
        });
    }

    // getting the data list with the listings and also next page id for pagination
    @Override
    public void onGetSuccess(String msg, List<Children> data, final String nextPage) {
        list.addAll(data);
        nextPageId = nextPage;
        Log.i(TAG, "Result : " + data.toString());
        int positionView = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        Log.i(TAG, "Position: " + positionView);
        recyclerView.scrollToPosition(positionView);
    }

    @Override
    public void onGetFailure(String msg) {

    }
}

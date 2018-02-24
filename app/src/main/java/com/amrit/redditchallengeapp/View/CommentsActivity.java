package com.amrit.redditchallengeapp.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.amrit.redditchallengeapp.Adapter.CustomAdapter;
import com.amrit.redditchallengeapp.GetResponse;
import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.CommentChildren;
import com.amrit.redditchallengeapp.Presenter.CommentPresenter;
import com.amrit.redditchallengeapp.R;

import java.util.List;

/**
 * Created by Amrit on 2/23/2018.
 */

// Activity to display the comments, Presenter has been implemented here also
public class CommentsActivity extends AppCompatActivity implements GetResponse.CommentsActivityView {

    String title;
    String permalink;
    private String TAG = "CommentsActivity";
    private CommentPresenter commentPresenter;
    private RecyclerView recyclerView;
    String url;
    String url1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // getting the listing details using bundle passed through the adapter class
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            title = bundle.getString("title");
            permalink = bundle.getString("permalink");
        }
        Log.i("CommentsActivity", "link : " + permalink);
        commentPresenter = new CommentPresenter(this);
        url1 = getResources().getString(R.string.url);
        url = url1 + permalink + ".json";
        // to fetch the list, onGetSuccess is called, url with the permalink is passed
        commentPresenter.getDataFromUrl(getApplicationContext(), url);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // getting the comment list and passing to the adapter
    @Override
    public void onGetSuccess(String msg, List<CommentChildren> commentList) {
        Log.i(TAG, "Result : " + commentList.toString());
        // passing the list to the adapter
        recyclerView.setAdapter(new CustomAdapter(this, commentList, R.layout.adapter_custom));
    }

    @Override
    public void onGetFailure(String msg) {

    }
}

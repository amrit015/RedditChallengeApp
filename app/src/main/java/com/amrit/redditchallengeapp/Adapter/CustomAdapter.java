package com.amrit.redditchallengeapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amrit.redditchallengeapp.Model.Children.Children;
import com.amrit.redditchallengeapp.Model.Children.Data.Data;
import com.amrit.redditchallengeapp.Model.Comments.CommentData.CommentChildren.CommentChildren;
import com.amrit.redditchallengeapp.R;
import com.amrit.redditchallengeapp.View.CommentsActivity;
import com.amrit.redditchallengeapp.View.ListingActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

/**
 * Created by Amrit on 2/23/2018.
 */

// Recyclerview Adapter to display the listing and comments in the recyclerview
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.DataHolder> {

    private List<Children> listingData;
    private Context context;
    private int rowLayout;
    private List<CommentChildren> commentData;

    public CustomAdapter(ListingActivity activity, List<Children> listingData, int listingLayout) {
        this.listingData = listingData;
        context = activity;
        rowLayout = listingLayout;
    }

    public CustomAdapter(CommentsActivity commentsActivity, List<CommentChildren> commentList, int commentLayout) {
        commentData = commentList;
        context = commentsActivity;
        rowLayout = commentLayout;
    }

    @Override
    public DataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.DataHolder holder, final int position) {
        // for displaying the listing items
        if (listingData!=null) {
            holder.title.setText(listingData.get(position).getDataList().getTitle());
            //using Glide to load images
            Glide.clear(holder.thumbnail);
            Glide.with(context)
                    .load(listingData.get(position).getDataList().getThumbnail())
                    .placeholder(R.drawable.image_failed)
                    .into(holder.thumbnail);

            // click events on the list, passing the title and permalink using bundle
            holder.cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Data data = listingData.get(position).getDataList();
                    Intent i = new Intent(context, CommentsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("title", data.getTitle());
                    bundle.putString("permalink", data.getPermalink());
                    i.putExtras(bundle);
                    context.startActivity(i);
                }
            });
        }

        // when the comment list has been passed
        if (commentData!=null){
            holder.listingLayout.setVisibility(View.GONE);
            holder.commentLayout.setVisibility(View.VISIBLE);
            holder.comments.setText(commentData.get(position).getCommentList().getBody());
        }
    }

    @Override
    public int getItemCount() {
        if (listingData!=null) {
            return listingData.size();
        }
        else {
            return commentData.size();
        }
    }

    // viewholder for the adapter CustomAdapter
    public class DataHolder extends RecyclerView.ViewHolder {
        LinearLayout listingLayout;
        CardView cardview;
        LinearLayout commentLayout;
        TextView title;
        ImageView thumbnail;
        TextView comments;

        public DataHolder(View v) {
            super(v);
            cardview = (CardView) v.findViewById(R.id.card_view);
            listingLayout = (LinearLayout) v.findViewById(R.id.listing_layout);
            commentLayout = (LinearLayout) v.findViewById(R.id.comment_layout);
            title = (TextView) v.findViewById(R.id.title);
            thumbnail = (ImageView) v.findViewById(R.id.thumbnail);
            comments = (TextView) v.findViewById(R.id.comment);
        }
    }
}
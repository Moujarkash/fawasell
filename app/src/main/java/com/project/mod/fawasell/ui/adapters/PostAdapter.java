package com.project.mod.fawasell.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.post.Post;
import com.project.mod.fawasell.ui.viewholders.PostViewHolder;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    //region Variables

    private List<Post> mPosts;

    //endregion

    //region Constructor

    public PostAdapter(List<Post> posts){
        mPosts = posts;
    }

    //endregion

    //region RecyclerView.Adapter Members

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_post, parent, false);

        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.bindObject(post);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    //endregion

    //region Public Members

    public void addPosts(List<Post> posts){
        if(mPosts == null)
            mPosts = new ArrayList<>();

        mPosts.addAll(posts);
        notifyItemRangeInserted(mPosts.size(), posts.size());
    }

    //endregion
}

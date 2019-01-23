package com.project.mod.fawasell.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.post.Post;
import com.project.mod.fawasell.ui.utils.DisplayHelper;
import com.squareup.picasso.Picasso;

public class PostViewHolder extends RecyclerView.ViewHolder {

    //region Variables

    private ImageView mPostImageView;
    private TextView mDescriptionTextView;
    private TextView mUserNameTextView;
    private TextView mCommentCountTextView;
    private TextView mLikeCountTextView;

    //endregion

    //region Constructor

    public PostViewHolder(View view){
        super(view);

        bindViews(view);
    }

    //endregion

    //region Public Members

    public void bindObject(Post post){
        mUserNameTextView.setText(post.getName());
        mDescriptionTextView.setText(post.getCaption());
        mCommentCountTextView.setText(DisplayHelper.getNumberUnitFormat(post.getCommentCount()));
        mLikeCountTextView.setText(DisplayHelper.getNumberUnitFormat(post.getLikeCount()));

        if(post.getMedia() == null)
            mPostImageView.setVisibility(View.GONE);
        else
            Picasso.get().load(post.getMedia().get(1).getUrl()).into(mPostImageView);
    }

    //endregion

    //region Private Members

    private void bindViews(View view){
        mPostImageView = view.findViewById(R.id.list_item_post_image_view);
        mDescriptionTextView = view.findViewById(R.id.list_item_post_description_text_view);
        mUserNameTextView = view.findViewById(R.id.list_item_post_user_name_text_view);
        mCommentCountTextView = view.findViewById(R.id.list_item_post_comment_count_text_view);
        mLikeCountTextView = view.findViewById(R.id.list_item_post_like_text_view);
    }

    //endregion
}

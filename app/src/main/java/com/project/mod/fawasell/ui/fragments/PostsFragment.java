package com.project.mod.fawasell.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.post.PostResponse;
import com.project.mod.fawasell.presenters.post.PostsPresenter;
import com.project.mod.fawasell.presenters.post.PostsView;

public class PostsFragment extends BaseFragment implements PostsView {

    //region Constants

    public static final String CATEGORY_ID_ARG = "CATEGORY_ID_ARG";

    //endregion

    //region Variables

    private PostsPresenter mPostsPresenter;
    private int mCategoryId = 0;

    //endregion

    //region Fragment Members

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            mCategoryId = getArguments().getInt(CATEGORY_ID_ARG, 0);

        mPostsPresenter = new PostsPresenter(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        setActionBarTitle(getString(R.string.post_title));
        mPostsPresenter.getPosts(getContext(), 1, 10);

        return view;
    }

    //endregion

    //region Private Members

    //endregion

    //region PostsView Members

    @Override
    public int getCategoryId() {
        return mCategoryId;
    }

    @Override
    public void updateOnFetchPosts(PostResponse postResponse) {

    }

    @Override
    public void displayLoadView() {

    }

    @Override
    public void removeLoadView() {

    }

    @Override
    public void displayRetryView() {

    }

    @Override
    public void removeRetryView() {

    }

    @Override
    public void displayErrorMessageDialog(String errorMessage) {

    }

    //endregion
}

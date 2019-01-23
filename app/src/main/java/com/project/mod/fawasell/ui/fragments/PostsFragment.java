package com.project.mod.fawasell.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.post.Post;
import com.project.mod.fawasell.models.post.PostResponse;
import com.project.mod.fawasell.presenters.post.PostsPresenter;
import com.project.mod.fawasell.presenters.post.PostsView;
import com.project.mod.fawasell.ui.adapters.PostAdapter;
import com.project.mod.fawasell.ui.utils.DisplayHelper;

import java.util.List;

public class PostsFragment extends BaseFragment implements PostsView {

    //region Constants

    public static final String CATEGORY_ID_ARG = "CATEGORY_ID_ARG";
    private static final int LIMIT = 10;

    //endregion

    //region Variables

    private RelativeLayout mLoadView;
    private RelativeLayout mRetryView;
    private ImageView mRetryImageView;
    private RecyclerView mRecyclerView;

    private PostsPresenter mPostsPresenter;
    private PostAdapter mPostAdapter;
    LinearLayoutManager mLayoutManager;
    private int mCategoryId = 0;
    private int mCurrentPage = 1;
    private int mTotalPages = 0;

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

        bindViews(view);
        attachListener();
        setActionBarTitle(getString(R.string.post_title));
        mPostsPresenter.getPosts(getContext(), mCurrentPage, LIMIT);

        return view;
    }

    //endregion

    //region Private Members

    private void bindViews(View view){
        mLoadView = view.findViewById(R.id.fragment_post_load_view);
        mRetryView = view.findViewById(R.id.fragment_post_retry_view);
        mRetryImageView = view.findViewById(R.id.layout_retry_image_view);
        mRecyclerView = view.findViewById(R.id.fragment_post_recycler_view);
    }

    private void attachListener(){
        mRetryImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mPostsPresenter.getPosts(getContext(), mCurrentPage, LIMIT);
            }
        });
    }

    private void initRecyclerView(List<Post> posts){
        if(posts == null) return;

        mPostAdapter = new PostAdapter(posts);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mPostAdapter);

        mRecyclerView.addOnScrollListener(recyclerViewOnScrollListener);
    }

    private void loadNextPosts(){
        mPostsPresenter.getPosts(getContext(), mCurrentPage + 1, LIMIT);
    }

    //endregion

    //region PostsView Members

    @Override
    public int getCategoryId() {
        return mCategoryId;
    }

    @Override
    public void updateOnFetchPosts(PostResponse postResponse) {
            mCurrentPage = postResponse.getPostMetaData().getPage();
            mTotalPages = postResponse.getPostMetaData().getPages();

            if(mCurrentPage == 1)
                initRecyclerView(postResponse.getPosts());
            else
                mPostAdapter.addPosts(postResponse.getPosts());
    }

    @Override
    public void displayLoadView() {
        if (mCurrentPage == 1)
            mLoadView.setVisibility(View.VISIBLE);
        DisplayHelper.hideSoftKeyboard(getActivity());
    }

    @Override
    public void removeLoadView() {
        mLoadView.setVisibility(View.GONE);
    }

    @Override
    public void displayRetryView() {
        if (mCurrentPage == 1)
            mRetryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeRetryView() {
        mRetryView.setVisibility(View.GONE);
    }

    @Override
    public void displayErrorMessageDialog(String errorMessage) {
        if (mCurrentPage == 1)
            DisplayHelper.displayMessageAlertDialog(getContext(), getString(R.string.error_dialog_title), errorMessage);
    }

    //endregion

    //region RecyclerView.OnScrollListener

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = mLayoutManager.getChildCount();
            int totalItemCount = mLayoutManager.getItemCount();
            int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

            if (mCurrentPage != mTotalPages) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= LIMIT) {
                    loadNextPosts();
                }
            }
        }
    };

    //endregion
}

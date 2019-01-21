package com.project.mod.fawasell.presenters.post;

import android.content.Context;
import android.util.Log;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.post.PostResponse;
import com.project.mod.fawasell.presenters.base.BasePresenter;
import com.project.mod.fawasell.repositories.PostRepository;

public class PostsPresenter extends BasePresenter<PostsView> {

    //region Constants

    private static final String TAG = PostsPresenter.class.getSimpleName();

    //endregion

    //region Variables

    private PostRepository mPostRepository;

    //endregion

    //region Constructor

    public PostsPresenter(PostsView view){
        super(view);
        mPostRepository = new PostRepository();
    }

    //endregion

    //region Members

    public void getPosts(final Context context, int page, int limit){
        mView.displayLoadView();
        mView.removeRetryView();

        if(!checkInternetConnection(context)) return;

        mPostRepository.getPosts(mView.getCategoryId(), page, limit, new CallBack() {

            @Override
            public void onResponse(Object response) {
                mView.removeLoadView();
                mView.removeRetryView();
                mView.updateOnFetchPosts((PostResponse) response);
            }

            @Override
            public void onFailure(String errorMessage) {
                mView.removeLoadView();
                mView.displayRetryView();
                mView.displayErrorMessageDialog(context.getString(R.string.something_wrong_happened));
                Log.e(TAG, errorMessage);
            }
        });
    }

    //endregion
}

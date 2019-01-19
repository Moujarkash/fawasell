package com.project.mod.fawasell.presenters.post;

import com.project.mod.fawasell.models.post.PostList;
import com.project.mod.fawasell.presenters.base.BasePresenter;
import com.project.mod.fawasell.repositories.PostRepository;

public class PostsPresenter extends BasePresenter<PostsView> {

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

    public void getPosts(int page, int limit){
        mView.displayLoadView();

        mPostRepository.getPosts(mView.getCategoryId(), page, limit, new CallBack() {

            @Override
            public void onResponse(Object response) {
                mView.removeLoadView();
                mView.updateOnFetchPosts((PostList) response);
            }

            @Override
            public void onFailure(String errorMessage) {
                mView.removeLoadView();
                mView.displayErrorMessageDialog(errorMessage);
            }
        });
    }

    //endregion
}

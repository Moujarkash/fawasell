package com.project.mod.fawasell.repositories;

import android.util.Log;

import com.project.mod.fawasell.base.EndPointContext;
import com.project.mod.fawasell.models.post.PostResponse;
import com.project.mod.fawasell.presenters.base.BasePresenter.CallBack;
import com.project.mod.fawasell.repositories.base.BaseRepository;
import com.project.mod.fawasell.rest.PostRest;
import com.project.mod.fawasell.rest.base.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository extends BaseRepository {

    //region Constants

    private static final String TAG = PostRepository.class.getSimpleName();

    //endregion

    //region Variables

    private PostRest mPostRest;

    //endregion

    //region Constructor

    public PostRepository() {
        mPostRest = ApiClient.getClient().create(PostRest.class);
    }

    //endregion

    //region Members

    public void getPosts(int categoryId, int page, int limit, final CallBack callBack){

        String signature = getSignature(categoryId, page, limit, EndPointContext.APP_ID, EndPointContext.APP_SECRET);

        Call<PostResponse> call = mPostRest.getPosts(categoryId, page, limit, EndPointContext.APP_ID, EndPointContext.APP_SECRET, signature);
        call.enqueue(new Callback<PostResponse>() {

            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                callBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                callBack.onFailure(t.getMessage());
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }

    //endregion
}

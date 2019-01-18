package com.project.mod.fawasell.repositories;

import android.util.Log;

import com.project.mod.fawasell.base.EndPointContext;
import com.project.mod.fawasell.models.category.CategoryList;
import com.project.mod.fawasell.presenters.base.BasePresenter.CallBack;
import com.project.mod.fawasell.repositories.base.BaseRepository;
import com.project.mod.fawasell.rest.CategoryRest;
import com.project.mod.fawasell.rest.base.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository extends BaseRepository {

    //region Constants

    private static final String TAG = CategoryRepository.class.getSimpleName();

    //endregion

    //region Variables

    private CategoryRest mCategoryRest;

    //endregion

    //region Constructor

    public CategoryRepository() {
        mCategoryRest = ApiClient.getClient().create(CategoryRest.class);
    }

    //endregion

    //region Members

    public void getCategories(final CallBack callBack){

        String signature = getSignature(EndPointContext.APP_ID, EndPointContext.APP_SECRET);

        Call<CategoryList> call = mCategoryRest.getCategories(EndPointContext.APP_ID, EndPointContext.APP_SECRET, signature);
        call.enqueue(new Callback<CategoryList>() {

            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {
                callBack.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
                callBack.onFailure(t.getMessage());
                Log.e(TAG, t.getMessage(), t);
            }
        });
    }

    //endregion
}

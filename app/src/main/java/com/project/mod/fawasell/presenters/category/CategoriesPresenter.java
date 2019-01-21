package com.project.mod.fawasell.presenters.category;

import android.content.Context;
import android.util.Log;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.category.CategoryResponse;
import com.project.mod.fawasell.presenters.base.BasePresenter;
import com.project.mod.fawasell.repositories.CategoryRepository;

public class CategoriesPresenter extends BasePresenter<CategoriesView> {

    //region Constants

    private static final String TAG = CategoriesPresenter.class.getSimpleName();

    //endregion

    //region Variables

    private CategoryRepository mCategoryRepository;

    //endregion

    //region Constructor

    public CategoriesPresenter(CategoriesView view){
        super(view);
        mCategoryRepository = new CategoryRepository();
    }

    //endregion

    //region Members

    public void getCategories(final Context context){
        mView.displayLoadView();
        mView.removeRetryView();

        if(!checkInternetConnection(context)) return;

        mCategoryRepository.getCategories(new CallBack() {

            @Override
            public void onResponse(Object response) {
                mView.removeLoadView();
                mView.removeRetryView();
                mView.updateOnFetchCategories((CategoryResponse) response);
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

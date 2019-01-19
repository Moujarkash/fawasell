package com.project.mod.fawasell.presenters.category;

import com.project.mod.fawasell.models.category.CategoryList;
import com.project.mod.fawasell.presenters.base.BasePresenter;
import com.project.mod.fawasell.repositories.CategoryRepository;

public class CategoriesPresenter extends BasePresenter<CategoriesView> {

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

    public void getCategories(){
        mView.displayLoadView();

        mCategoryRepository.getCategories(new CallBack() {

            @Override
            public void onResponse(Object response) {
                mView.removeLoadView();
                mView.updateOnFetchCategories((CategoryList) response);
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

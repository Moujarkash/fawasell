package com.project.mod.fawasell.presenters.base;

public abstract class BasePresenter {

    //region Variables

    protected View mView;

    //endregion

    //region Constructor

    public BasePresenter(View view){
        mView = view;
    }

    //endregion

    //region CallBack

    public interface CallBack{

        void onResponse(Object response);

        void onFailure(String errorMessage);
    }

    //endregion
}

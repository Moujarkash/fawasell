package com.project.mod.fawasell.presenters.base;

public abstract class BasePresenter<T extends View> {

    //region Variables

    protected T mView;

    //endregion

    //region Constructor

    public BasePresenter(T view){
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

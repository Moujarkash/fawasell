package com.project.mod.fawasell.presenters.base;

import android.content.Context;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.utils.GeneralHelper;

public abstract class BasePresenter<T extends View> {

    //region Variables

    protected T mView;

    //endregion

    //region Constructor

    public BasePresenter(T view){
        mView = view;
    }

    //endregion

    //region Members

    protected boolean checkInternetConnection(Context context){
        boolean isConnected = GeneralHelper.isNetworkConnected(context);

        if(!isConnected) {
            mView.removeLoadView();
            mView.displayRetryView();
            mView.displayErrorMessageDialog(context.getString(R.string.please_check_your_internet_connection));
        }

        return isConnected;
    }

    //endregion

    //region CallBack

    public interface CallBack{

        void onResponse(Object response);

        void onFailure(String errorMessage);
    }

    //endregion
}

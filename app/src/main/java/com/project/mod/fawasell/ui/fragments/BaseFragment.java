package com.project.mod.fawasell.ui.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    //region Variables

    private OnFragmentInteractionListener mOnFragmentInteractionListener;

    //endregion

    //region Fragment Members

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnFragmentInteractionListener)
            mOnFragmentInteractionListener = (OnFragmentInteractionListener) context;
    }

    //endregion

    //region Members

    protected void setActionBarTitle(String title){
        if (mOnFragmentInteractionListener != null) {
            mOnFragmentInteractionListener.onFragmentInteraction(title);
        }
    }

    //endregion

    //region OnFragmentInteractionListener

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(String title);
    }

    //endregion
}

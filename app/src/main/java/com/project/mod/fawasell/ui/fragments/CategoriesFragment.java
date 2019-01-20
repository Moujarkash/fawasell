package com.project.mod.fawasell.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.category.Category;
import com.project.mod.fawasell.models.category.CategoryList;
import com.project.mod.fawasell.presenters.category.CategoriesPresenter;
import com.project.mod.fawasell.presenters.category.CategoriesView;
import com.project.mod.fawasell.ui.adapters.CategoryAdapter;
import com.project.mod.fawasell.ui.utils.DisplayHelper;
import com.project.mod.fawasell.ui.viewholders.CategoryViewHolder;

import java.util.List;

public class CategoriesFragment extends Fragment implements CategoriesView, CategoryViewHolder.OnCategoryClickListener {

    //region Variables

    private RelativeLayout mLoadView;
    private RelativeLayout mRetryView;
    private RecyclerView mRecyclerView;
    private ImageView mRetryImageView;

    private CategoriesPresenter mCategoriesPresenter;
    private OnFragmentInteractionListener mOnFragmentInteractionListener;

    //endregion

    //region Fragment Members

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCategoriesPresenter = new CategoriesPresenter(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        bindViews(view);
        attachListener();
        setActionBarTitle();
        mCategoriesPresenter.getCategories();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof OnFragmentInteractionListener)
            mOnFragmentInteractionListener = (OnFragmentInteractionListener) context;
    }

    //endregion

    //region Private Members

    private void bindViews(View view){
        mRecyclerView = view.findViewById(R.id.fragment_category_recycler_view);
        mLoadView = view.findViewById(R.id.fragment_category_load_view);
        mRetryView = view.findViewById(R.id.fragment_category_retry_view);
        mRetryImageView = view.findViewById(R.id.layout_retry_image_view);
    }

    private void setActionBarTitle(){
        if (mOnFragmentInteractionListener != null) {
            mOnFragmentInteractionListener.onFragmentInteraction(getString(R.string.category_title));
        }
    }

    private void initRecyclerView(List<Category> categories){
        if(categories == null) return;

        CategoryAdapter adapter = new CategoryAdapter(categories, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
    }

    private void attachListener(){
        mRetryImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCategoriesPresenter.getCategories();
            }
        });
    }

    //endregion

    //region CategoriesView

    @Override
    public void updateOnFetchCategories(CategoryList categoryList) {
        initRecyclerView(categoryList.getCategories());
    }

    @Override
    public void displayLoadView() {
        mLoadView.setVisibility(View.VISIBLE);
        DisplayHelper.hideSoftKeyboard(getActivity());
    }

    @Override
    public void removeLoadView() {
        mLoadView.setVisibility(View.GONE);
    }

    @Override
    public void displayRetryView() {
        mRetryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeRetryView() {
        mRetryView.setVisibility(View.GONE);
    }

    @Override
    public void displayErrorMessageDialog(String errorMessage) {
        DisplayHelper.displayMessageAlertDialog(getContext(), getString(R.string.error_dialog_title), errorMessage);
    }

    //endregion

    //region OnCategoryClickListener

    @Override
    public void onCategoryClick(Category category) {

    }

    //endregion

    //region OnFragmentInteractionListener

    public interface OnFragmentInteractionListener {

         void onFragmentInteraction(String title);
    }

    //endregion
}

package com.project.mod.fawasell.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.category.Category;
import com.project.mod.fawasell.ui.viewholders.CategoryViewHolder;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    //region Variables

    private List<Category> mCategories;
    private CategoryViewHolder.OnCategoryClickListener mOnCategoryClickListener;

    //endregion

    //region Constructor

    public CategoryAdapter(List<Category> categories, CategoryViewHolder.OnCategoryClickListener onCategoryClickListener){
        mCategories = categories;
        mOnCategoryClickListener = onCategoryClickListener;
    }

    //endregion

    //region RecyclerView.Adapter Members

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_category, parent, false);

        return new CategoryViewHolder(itemView, mOnCategoryClickListener);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = mCategories.get(position);
        holder.bindObject(category);
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    //endregion
}

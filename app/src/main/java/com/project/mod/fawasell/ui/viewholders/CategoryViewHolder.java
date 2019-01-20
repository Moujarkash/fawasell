package com.project.mod.fawasell.ui.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.mod.fawasell.R;
import com.project.mod.fawasell.models.category.Category;
import com.squareup.picasso.Picasso;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    //region Variables

   private ImageView mLogoImageView;
   private TextView mTitleTextView;

   private Category mCategory;
   private OnCategoryClickListener mOnCategoryClickListener;

    //endregion

    //region Constructor

    public CategoryViewHolder(View view, OnCategoryClickListener onCategoryClickListener){
        super(view);
        mOnCategoryClickListener = onCategoryClickListener;

        bindViews(view);
        attachListener(view);
    }

    //endregion

    //region Public Members

    public void bindObject(Category category){
        mCategory = category;

        mTitleTextView.setText(category.getName());
        Picasso.get().load(category.getImage()).into(mLogoImageView);
    }

    //endregion

    //region Private Members

    private void bindViews(View view){
        mLogoImageView = view.findViewById(R.id.list_item_category_logo_image_view);
        mTitleTextView = view.findViewById(R.id.list_item_category_title_text_view);
    }

    private void attachListener(View view){
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mOnCategoryClickListener != null)
                    mOnCategoryClickListener.onCategoryClick(mCategory);
            }
        });
    }

    //endregion

    //region OnCategoryClickListener

    public interface OnCategoryClickListener{

        void onCategoryClick(Category category);
    }

    //endregion
}

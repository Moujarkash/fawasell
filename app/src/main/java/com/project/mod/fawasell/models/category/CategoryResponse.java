package com.project.mod.fawasell.models.category;

import com.google.gson.annotations.SerializedName;
import com.project.mod.fawasell.base.EndPointContext;

import java.util.List;

public class CategoryResponse {

    //region Variables

    @SerializedName(EndPointContext.DATA)
    private List<Category> mCategories;

    //endregion

    //region Constructor

    public CategoryResponse(){}

    //endregion

    //region Getters && Setters

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    //endregion
}

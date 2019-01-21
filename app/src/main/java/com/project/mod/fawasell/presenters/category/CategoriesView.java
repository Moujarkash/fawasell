package com.project.mod.fawasell.presenters.category;

import com.project.mod.fawasell.models.category.CategoryResponse;
import com.project.mod.fawasell.presenters.base.View;

public interface CategoriesView extends View {

    void updateOnFetchCategories(CategoryResponse categoryResponse);
}

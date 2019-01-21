package com.project.mod.fawasell.models.post;

import com.google.gson.annotations.SerializedName;
import com.project.mod.fawasell.base.EndPointContext.Post.Response;

public class PostMetaData {

    //region Variables

    @SerializedName(Response.PAGE)
    private int mPage;

    @SerializedName(Response.PAGES)
    private int mPages;

    @SerializedName(Response.SHOWING)
    private int mShowing;

    //endregion

    //region Constructor

    public PostMetaData(){}

    //endregion

    //region Getters && Setters

    public int getPage() {
        return mPage;
    }

    public void setPage(int page) {
        mPage = page;
    }

    public int getPages() {
        return mPages;
    }

    public void setPages(int pages) {
        mPages = pages;
    }

    public int getShowing() {
        return mShowing;
    }

    public void setShowing(int showing) {
        mShowing = showing;
    }

    //endregion
}

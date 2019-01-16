package com.project.mod.fawasell.models.media;

import com.google.gson.annotations.SerializedName;
import com.project.mod.fawasell.base.EndPointContext.Media.Response;

public class Media {

    //region Variables

    @SerializedName(Response.TYPE)
    private String mType;

    @SerializedName(Response.URL)
    private String mUrl;

    @SerializedName(Response.TITLE)
    private String mTitle;

    //endregion

    //region Constructor

    public Media(){}

    //endregion

    //region Getters && Setters

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    //endregion
}

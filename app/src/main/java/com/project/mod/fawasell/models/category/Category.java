package com.project.mod.fawasell.models.category;

import com.google.gson.annotations.SerializedName;
import com.project.mod.fawasell.base.EndPointContext.Category.Response;

public class Category {

    //region Variables

    @SerializedName(Response.ID)
    private int mId;

    @SerializedName(Response.NAME)
    private String mName;

    @SerializedName(Response.IMAGE)
    private String mImage;

    @SerializedName(Response.DESCRIPTION)
    private String mDescription;

    //endregion

    //region Constructor

    public Category(){}

    //endregion

    //region Getters && Setters

    public int getId() {
        return mId;
    }

    public void setId(int Id) {
        mId = Id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    //endregion
}

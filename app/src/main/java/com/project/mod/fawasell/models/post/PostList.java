package com.project.mod.fawasell.models.post;

import com.google.gson.annotations.SerializedName;
import com.project.mod.fawasell.base.EndPointContext;

import java.util.List;

public class PostList {

    //region Variables

    @SerializedName(EndPointContext.DATA)
    private List<Post> mPosts;

    //endregion

    //region Constructor

    public PostList(){}

    //endregion

    //region Getters && Setters

    public List<Post> getPosts() {
        return mPosts;
    }

    public void setPosts(List<Post> posts) {
        mPosts = posts;
    }

    //endregion
}

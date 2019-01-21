package com.project.mod.fawasell.models.post;

import com.google.gson.annotations.SerializedName;
import com.project.mod.fawasell.base.EndPointContext;

import java.util.List;

public class PostResponse {

    //region Variables

    @SerializedName(EndPointContext.DATA)
    private List<Post> mPosts;

    @SerializedName(EndPointContext.META)
    private PostMetaData mPostMetaData;

    //endregion

    //region Constructor

    public PostResponse(){}

    //endregion

    //region Getters && Setters

    public List<Post> getPosts() {
        return mPosts;
    }

    public void setPosts(List<Post> posts) {
        mPosts = posts;
    }

    public PostMetaData getPostMetaData() {
        return mPostMetaData;
    }

    public void setPostMetaData(PostMetaData postMetaData) {
        mPostMetaData = postMetaData;
    }

    //endregion
}

package com.project.mod.fawasell.models.post;

import com.google.gson.annotations.SerializedName;
import com.project.mod.fawasell.base.EndPointContext.Post.Response;
import com.project.mod.fawasell.models.media.Media;

import java.util.Date;
import java.util.List;

public class Post {

    //region Variables

    @SerializedName(Response.ID)
    private int mId;

    @SerializedName(Response.USER_NAME)
    private String mUserName;

    @SerializedName(Response.NAME)
    private String mName;

    @SerializedName(Response.CAPTION)
    private String mCaption;

    @SerializedName(Response.TYPE)
    private String mType;

    @SerializedName(Response.CATEGORY_ID)
    private int mCategoryId;

    @SerializedName(Response.URL)
    private String mUrl;

    @SerializedName(Response.VIEW_COUNT)
    private int mViewCount;

    @SerializedName(Response.LIKE_COUNT)
    private int mLikeCount;

    @SerializedName(Response.DISLIKE_COUNT)
    private int mDislikeCount;

    @SerializedName(Response.COMMENT_COUNT)
    private int mCommentCount;

    @SerializedName(Response.RANKING_SCORE)
    private int mRankingScore;

    @SerializedName(Response.CREATED_AT)
    private Date mCreatedAt;

    @SerializedName(Response.MEDIA)
    private List<Media> mMedia;

    //endregion

    //region Constructor

    public Post(){}

    //endregion

    //region Getters && Setters

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public int getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(int categoryId) {
        mCategoryId = categoryId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public int getViewCount() {
        return mViewCount;
    }

    public void setViewCount(int viewCount) {
        mViewCount = viewCount;
    }

    public int getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(int likeCount) {
        mLikeCount = likeCount;
    }

    public int getDislikeCount() {
        return mDislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        mDislikeCount = dislikeCount;
    }

    public int getCommentCount() {
        return mCommentCount;
    }

    public void setCommentCount(int commentCount) {
        mCommentCount = commentCount;
    }

    public int getRankingScore() {
        return mRankingScore;
    }

    public void setRankingScore(int rankingScore) {
        mRankingScore = rankingScore;
    }

    public Date getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        mCreatedAt = createdAt;
    }

    public List<Media> getMedia() {
        return mMedia;
    }

    public void setMedia(List<Media> media) {
        mMedia = media;
    }

    //endregion
}

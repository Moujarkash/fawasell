package com.project.mod.fawasell.rest;

import com.project.mod.fawasell.base.EndPointContext.Post.Methods.GetPosts.Parameters;
import com.project.mod.fawasell.models.post.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.project.mod.fawasell.base.EndPointContext.Post.SEGMENT;

public interface PostRest {

    @GET(SEGMENT)
    Call<PostResponse> getPosts(@Query(Parameters.CATEGORY) int categoryId, @Query(Parameters.PAGE) int page, @Query(Parameters.LIMIT) int limit, @Query(Parameters.APP_ID) int appId, @Query(Parameters.APP_SECRET) String appSecret, @Query(Parameters.SIGNATURE) String signature);
}

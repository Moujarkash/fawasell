package com.project.mod.fawasell.rest;

import com.project.mod.fawasell.base.EndPointContext.Category.Methods.GetCategories.Parameters;
import com.project.mod.fawasell.models.category.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.project.mod.fawasell.base.EndPointContext.Category.SEGMENT;

public interface CategoryRest {

    @GET(SEGMENT)
    Call<List<Category>> getCategories(@Query(Parameters.APP_ID) int appId, @Query(Parameters.APP_SECRET) String appSecret, @Query(Parameters.SIGNATURE) String signature);
}

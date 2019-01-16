package com.project.mod.fawasell.rest.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.mod.fawasell.base.EndPointContext;
import com.project.mod.fawasell.utils.DateDeserializer;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //region Variables

    private static Retrofit mRetrofit;

    //endregion

    //region Public Members

    public static Retrofit getClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .setDateFormat("MM/dd/yyyy")
                .create();

        if(mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(EndPointContext.BASE_URI)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return mRetrofit;
    }

    //endregion
}

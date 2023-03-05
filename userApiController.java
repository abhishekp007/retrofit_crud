package com.example.retrofit_crud;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class userApiController {

    private  static final String BaseUrl = "http://192.168.0.106/";
    private  static userApiController clientobject;
    private static Retrofit retrofit;

    public userApiController() {

        retrofit = new Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();

    }

    public  static synchronized userApiController getInstance(){
        if (clientobject == null)
        {
            clientobject = new userApiController();
        }
        return clientobject;
    }

    userApiService getuserApiService()
    {
        return retrofit.create(userApiService.class);
    }
}

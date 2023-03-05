package com.example.retrofit_crud;

import com.example.retrofit_crud.Model.userModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface userApiService {

    @GET("crud/")
    Call<List<userModel>> getUser();

    @GET("crud/")
    Call<List<userModel>> getUserById(@Query("id") int id);

    @FormUrlEncoded
    @POST("crud/")
    Call<userModel> addUser(@Field("name") String name,@Field("job") String job,@Field("imglink") String imglink);
}

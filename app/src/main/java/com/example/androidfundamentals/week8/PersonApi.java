package com.example.androidfundamentals.week8;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PersonApi {

    @GET("/rwxGoogle/AndroidFundamentals2021/master/{fileName}")
    Call<List<User>> getUsers(@Path("fileName") String jsonToFetch);
}

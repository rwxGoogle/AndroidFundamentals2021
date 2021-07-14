package com.example.androidfundamentals.week9;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by roxanan on 9,June,2020
 */
public interface PersonApi {

    @GET("/rwxGoogle/AndroidFundamentals2021/master/{fileName}")
    Call<List<Person>> getPersons(@Path("fileName") String jsonToFetch);
}

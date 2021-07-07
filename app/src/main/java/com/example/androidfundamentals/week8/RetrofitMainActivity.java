package com.example.androidfundamentals.week8;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidfundamentals.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMainActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static final String FIRST_FILE = "test_json1";
    private static final String SECOND_FILE = "test_json2";
    private static Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main_activity);

        PersonApi api = getRetrofit().create(PersonApi.class);
        Call<List<User>> persons = api.getUsers(FIRST_FILE);
        persons.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response", response.body().toString());
                    Log.d("Response code", String.valueOf(response.code()));

                    List<User> users = response.body();

                    for (User user : users) {
                        String childName = user.getChild().getName();
                        Log.d("Response", "Username= " + user.getName() + " childName= " + childName);
                    }

                } else {
                    Log.d("Response", "Response code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.w("Response", "Error in call", t);
            }
        });
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

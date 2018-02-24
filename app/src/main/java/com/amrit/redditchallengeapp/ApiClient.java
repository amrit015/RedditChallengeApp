package com.amrit.redditchallengeapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amrit on 2/22/2018.
 */

// Retrofit Builder
public class ApiClient {

    private static String BASE_URL = "https://www.reddit.com";
    private static Retrofit retrofit = null;
    public static Retrofit getResponse(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

package com.example.nickg.simpleapicallanddisplay.network;

import com.example.nickg.simpleapicallanddisplay.Constants;

import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiEndPoints endPoints;


    public static ApiEndPoints getService() {
        if (endPoints == null) {
            // create OkHttp client
            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(logging);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClientBuilder.build())
                    .build();

            endPoints = retrofit.create(ApiEndPoints.class);
        }
        return endPoints;

    }



}

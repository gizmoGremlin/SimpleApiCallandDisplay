package com.example.nickg.simpleapicallanddisplay.network;

import com.example.nickg.simpleapicallanddisplay.Constants;
import com.example.nickg.simpleapicallanddisplay.model.Forex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
//https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,GBP,EUR,CAD

public interface ApiEndPoints {


    //@GET(Constants.PATH)
 //   Call<ApiResponse> fetchForex(@Query("fsym") String altCoin, @Query("tsyms") String exc1, String exc2,String exc3, String exc4,@Query("api_key") String apiKey);
    @GET("data/price?fsym=BTC&tsyms=USD,GBP,EUR,CAD")
    Call<Forex>fetchForex();
}

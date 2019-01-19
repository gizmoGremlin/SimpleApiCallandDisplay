package com.example.nickg.simpleapicallanddisplay;



import com.example.nickg.simpleapicallanddisplay.model.Forex;
import com.example.nickg.simpleapicallanddisplay.network.ApiEndPoints;
import com.example.nickg.simpleapicallanddisplay.network.ApiResponse;
import com.example.nickg.simpleapicallanddisplay.network.ApiService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepo {

    public ApiEndPoints endPoints;

    public ApiRepo(){
        endPoints = ApiService.getService();
    }

    public LiveData<ApiResponse> getForexValues(){
        final MutableLiveData<ApiResponse> apiReponse = new MutableLiveData<>();

        Call<Forex> call = endPoints.fetchForex();
        call.enqueue(new Callback<Forex>() {
            @Override
            public void onResponse(Call<Forex> call, Response<Forex> response) {
                if(response.isSuccessful()){
                    apiReponse.postValue(new ApiResponse(response.body()));
                }
            }

            @Override
            public void onFailure(Call<Forex> call, Throwable t) {
                apiReponse.postValue(new ApiResponse(t));
            }
        });

        return apiReponse;

    }


}

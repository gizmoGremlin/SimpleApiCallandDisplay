package com.example.nickg.simpleapicallanddisplay.ui.main;

import com.example.nickg.simpleapicallanddisplay.ApiRepo;
import com.example.nickg.simpleapicallanddisplay.network.ApiResponse;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MediatorLiveData<ApiResponse> apiResponseMediatorLiveData;
    private ApiRepo apiRepo;

    public MainViewModel() {
        apiResponseMediatorLiveData = new MediatorLiveData<>();
        apiRepo = new ApiRepo();
    }

    public LiveData<ApiResponse> getData(){
        apiResponseMediatorLiveData.addSource(apiRepo.getForexValues(), new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {

               apiResponseMediatorLiveData.setValue(apiResponse);
            }
        });
        return apiResponseMediatorLiveData;


    }
}
package com.example.nickg.simpleapicallanddisplay.network;

import com.example.nickg.simpleapicallanddisplay.model.Forex;
import com.google.gson.annotations.SerializedName;

import java.util.List;

//wrapper class to communicate success and errors from repo to viewmodel to activity
public class ApiResponse {

    public Forex exchangeValues;
    private Throwable error;
    public double CAD;
    public double USD;
    public double GBP;
    public double EURO;

    public ApiResponse(Forex forex){

        this.exchangeValues = forex;
        this.CAD = forex.getCAD();
        this.USD = forex.getUSD();
        this.EURO = forex.getEUR();
        this.GBP = forex.getGBP();
        this.error = null;

    }
    public ApiResponse(Throwable error){
        this.error = error;
        this.exchangeValues = null;
    }
    public double getForexCAD() {
        return exchangeValues.getCAD();
    }
    public double getForexUSD() {
        return exchangeValues.getUSD();
    }
    public double getForexGBP(){
        return exchangeValues.getGBP();
    }
    public double getForexEuro(){
        return exchangeValues.getEUR();
    }

    public Forex getExchangeValues() {
        return exchangeValues;
    }

    public void setExchangeValues(Forex exchangeValues) {
        this.exchangeValues = exchangeValues;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }
}




package com.example.nickg.simpleapicallanddisplay.model;

public  class Forex {

    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("CAD")
    private double CAD;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("EUR")
    private double EUR;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("GBP")
    private double GBP;
    @com.google.gson.annotations.Expose
    @com.google.gson.annotations.SerializedName("USD")
    private double USD;

    public double getCAD() {
        return CAD;
    }

    public void setCAD(double CAD) {
        this.CAD = CAD;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getGBP() {
        return GBP;
    }

    public void setGBP(double GBP) {
        this.GBP = GBP;
    }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }
}

package com.example.android.cryptoconversionapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ETORO on 27/10/2017.
 */

public class Currency implements Parcelable {

    @SerializedName("USD")
    @Expose
    private String usa;

    @SerializedName("GBP")
    @Expose
    private String britain;

    @SerializedName("CAD")
    @Expose
    private String canada;

    @SerializedName("CNY")
    @Expose
    private String china;

    @SerializedName("INR")
    @Expose
    private String india;

    @SerializedName("MYR")
    @Expose
    private String malaysia;

    @SerializedName("SGD")
    @Expose
    private String singapore;

    @SerializedName("CHF")
    @Expose
    private String switzerland;

    @SerializedName("QAR")
    @Expose
    private String qatar;

    @SerializedName("SEK")
    @Expose
    private String sweden;

    @SerializedName("RWF")
    @Expose
    private String rwanda;

    @SerializedName("NGN")
    @Expose
    private String nigeria;

    @SerializedName("NAD")
    @Expose
    private String namibia;

    @SerializedName("BRL")
    @Expose
    private String brazil;

    @SerializedName("ARS")
    @Expose
    private String argentina;

    @SerializedName("EGP")
    @Expose
    private String egypt;

    @SerializedName("ILS")
    @Expose
    private String israel;

    @SerializedName("ZAR")
    @Expose
    private String southAfrica;

    @SerializedName("MEXICO")
    @Expose
    private String mexico;

    @SerializedName("RUB")
    @Expose
    private String russia;

    @SerializedName("EUR")
    @Expose
    private String euros;

    private String currencyName;
    private String currencyRate;
    private String countryName;
    private int countryFlag;

    public int getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(int countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(String currencyRate) {
        this.currencyRate = currencyRate;
    }


    public Currency(String currencyName, String currencyRate, String countryName, int countryFlag){
        this.currencyName = currencyName;
        this.currencyRate = currencyRate;
        setCountryName(countryName);
        setCountryFlag(countryFlag);
    }

    public String getUsa() {
        return usa;
    }

    public void setUsa(String usa) {
        this.usa = usa;
    }

    public String getBritain() {
        return britain;
    }

    public void setBritain(String britain) {
        this.britain = britain;
    }

    public String getCanada() {
        return canada;
    }

    public void setCanada(String canada) {
        this.canada = canada;
    }

    public String getChina() {
        return china;
    }

    public void setChina(String china) {
        this.china = china;
    }

    public String getIndia() {
        return india;
    }

    public void setIndia(String india) {
        this.india = india;
    }

    public String getMalaysia() {
        return malaysia;
    }

    public void setMalaysia(String malaysia) {
        this.malaysia = malaysia;
    }

    public String getSingapore() {
        return singapore;
    }

    public void setSingapore(String singapore) {
        this.singapore = singapore;
    }

    public String getSwitzerland() {
        return switzerland;
    }

    public void setSwitzerland(String switzerland) {
        this.switzerland = switzerland;
    }

    public String getQatar() {
        return qatar;
    }

    public void setQatar(String qatar) {
        this.qatar = qatar;
    }

    public String getSweden() {
        return sweden;
    }

    public void setSweden(String sweden) {
        this.sweden = sweden;
    }

    public String getRwanda() {
        return rwanda;
    }

    public void setRwanda(String rwanda) {
        this.rwanda = rwanda;
    }

    public String getNigeria() {
        return nigeria;
    }

    public void setNigeria(String nigeria) {
        this.nigeria = nigeria;
    }

    public String getNamibia() {
        return namibia;
    }

    public void setNamibia(String namibia) {
        this.namibia = namibia;
    }

    public String getBrazil() {
        return brazil;
    }

    public void setBrazil(String brazil) {
        this.brazil = brazil;
    }

    public String getArgentina() {
        return argentina;
    }

    public void setArgentina(String argentina) {
        this.argentina = argentina;
    }

    public String getEgypt() {
        return egypt;
    }

    public void setEgypt(String egypt) {
        this.egypt = egypt;
    }

    public String getIsrael() {
        return israel;
    }

    public void setIsrael(String israel) {
        this.israel = israel;
    }

    public String getSouthAfrica() {
        return southAfrica;
    }

    public void setSouthAfrica(String southAfrica) {
        this.southAfrica = southAfrica;
    }

    public String getMexico() {
        return mexico;
    }

    public void setMexico(String mexico) {
        this.mexico = mexico;
    }

    public String getRussia() {
        return russia;
    }

    public void setRussia(String russia) {
        this.russia = russia;
    }

    public String getEuros() {
        return euros;
    }

    public void setEuros(String euros) {
        this.euros = euros;
    }


    protected Currency(Parcel in){

        //must be in the same way as the written in the dest.write
        usa = in.readString();
        britain = in.readString();
        canada = in.readString();
        china = in.readString();
        india = in.readString();
        malaysia = in.readString();
        singapore = in.readString();
        switzerland = in.readString();
        qatar = in.readString();
        sweden = in.readString();
        rwanda = in.readString();
        nigeria =in.readString();
        namibia = in.readString();
        brazil =in.readString();
        argentina = in.readString();
        egypt =in.readString();
        israel =in.readString();
        southAfrica =in.readString();
        russia = in.readString();
        euros = in.readString();
        countryName = in.readString();
        countryFlag =in.readInt();
        currencyRate =in.readString();
        currencyName = in.readString();


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {


        //this values must be written in exactly the same order as it was written in the in.read
        //else it will write the wrong value into the variable
        dest.writeString(usa);
        dest.writeString(britain);
        dest.writeString(canada);
        dest.writeString(china);
        dest.writeString(india);
        dest.writeString(malaysia);
        dest.writeString(singapore);
        dest.writeString(switzerland);
        dest.writeString(qatar);
        dest.writeString(sweden);
        dest.writeString(rwanda);
        dest.writeString(nigeria);
        dest.writeString(namibia);
        dest.writeString(brazil);
        dest.writeString(argentina);
        dest.writeString(egypt);
        dest.writeString(israel);
        dest.writeString(southAfrica);
        dest.writeString(russia);
        dest.writeString(euros);
        dest.writeString(countryName);
        dest.writeInt(countryFlag);
        dest.writeString(currencyRate);
        dest.writeString(currencyName);
    }

    public static final Creator<Currency> CREATOR = new Creator<Currency>() {
        @Override
        public Currency createFromParcel(Parcel source) {
            return new Currency(source);
        }

        @Override
        public Currency[] newArray(int size) {
            return new Currency[size];
        }
    };
}

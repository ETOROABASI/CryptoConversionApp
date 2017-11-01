package com.example.android.cryptoconversionapp.model;

import com.example.android.cryptoconversionapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ETORO on 27/10/2017.
 */

public class CurrencyResponse {

    //TODO TRY PUTTING BTC AND ETH IN DIFFERENT CLASSES

    @SerializedName("BTC")
    @Expose
    private Currency btc;


    @SerializedName("ETH")
    @Expose
    private Currency eth;


    public Currency getBtc() {
        return btc;
    }

    public Currency getEth() {
        return eth;
    }

    public ArrayList<Currency> getBtcCurrencyList(){
        ArrayList<Currency> btcCurrencyList = new ArrayList<>();

        btcCurrencyList.add(new Currency("USD", getBtc().getUsa(), "United States", R.drawable.usa));
        btcCurrencyList.add(new Currency("GBP", getBtc().getBritain(), "Great Britain", R.drawable.great_britain_flag));
        btcCurrencyList.add(new Currency("CAD", getBtc().getCanada(), "Canada", R.drawable.canada));
        btcCurrencyList.add(new Currency("CNY", getBtc().getChina(), "China", R.drawable.china));
        btcCurrencyList.add(new Currency("INR", getBtc().getIndia(), "India", R.drawable.india));
        btcCurrencyList.add(new Currency("MYR", getBtc().getMalaysia(), "Malaysia", R.drawable.malaysia));
        btcCurrencyList.add(new Currency("SGD", getBtc().getSingapore(), "Singapore", R.drawable.singapore));
        btcCurrencyList.add(new Currency("CHF", getBtc().getSwitzerland(), "Switzerland", R.drawable.switzerland1));
        btcCurrencyList.add(new Currency("QAR", getBtc().getQatar(), "Qatar", R.drawable.qatar));
        btcCurrencyList.add(new Currency("SEK", getBtc().getSweden(), "Sweden",R.drawable.sweden2));
        btcCurrencyList.add(new Currency("RWF", getBtc().getRwanda(), "Rwanda", R.drawable.rwanda));
        btcCurrencyList.add(new Currency("NGN", getBtc().getNigeria(), "Nigeria", R.drawable.nigeria));
        btcCurrencyList.add(new Currency("NAD", getBtc().getNamibia(), "Namibia", R.drawable.namibia));
        btcCurrencyList.add(new Currency("BRL", getBtc().getBrazil(), "Brazil", R.drawable.brazil));
        btcCurrencyList.add(new Currency("ARS", getBtc().getArgentina(), "Argentina", R.drawable.argentina));
        btcCurrencyList.add(new Currency("EGP", getBtc().getEgypt(), "Egypt", R.drawable.egypt));
        btcCurrencyList.add(new Currency("ILS", getBtc().getIsrael(), "Israel", R.drawable.israel));
        btcCurrencyList.add(new Currency("ZAR", getBtc().getSouthAfrica(), "South Africa", R.drawable.southafrica));
        //btcCurrencyList.add(new Currency("MXN", getBtc().getMexico()));
        btcCurrencyList.add(new Currency("RUB", getBtc().getRussia(), "Russia", R.drawable.russia));
        btcCurrencyList.add(new Currency("EUR", getBtc().getEuros(), "Euros", R.drawable.euros));

        return btcCurrencyList;
    }

    public ArrayList<Currency> getEthCurrencyList(){
        ArrayList<Currency> ethCurrencyList = new ArrayList<>();

        ethCurrencyList.add(new Currency("USD", getEth().getUsa(), "United States", R.drawable.usa));
        ethCurrencyList.add(new Currency("GBP", getEth().getBritain(), "Great Britain", R.drawable.great_britain_flag));
        ethCurrencyList.add(new Currency("CAD", getEth().getCanada(), "Canada", R.drawable.canada));
        ethCurrencyList.add(new Currency("CNY", getEth().getChina(), "China", R.drawable.china));
        ethCurrencyList.add(new Currency("INR", getEth().getIndia(), "India", R.drawable.india));
        ethCurrencyList.add(new Currency("MYR", getEth().getMalaysia(), "Malaysia", R.drawable.malaysia));
        ethCurrencyList.add(new Currency("SGD", getEth().getSingapore(), "Singapore", R.drawable.singapore));
        ethCurrencyList.add(new Currency("CHF", getEth().getSwitzerland(), "Switzerland", R.drawable.switzerland1));
        ethCurrencyList.add(new Currency("QAR", getEth().getQatar(), "Qatar", R.drawable.qatar));
        ethCurrencyList.add(new Currency("SEK", getEth().getSweden(), "Sweden", R.drawable.sweden2));
        ethCurrencyList.add(new Currency("RWF", getEth().getRwanda(), "Rwanda", R.drawable.rwanda));
        ethCurrencyList.add(new Currency("NGN", getEth().getNigeria(), "Nigeria", R.drawable.nigeria));
        ethCurrencyList.add(new Currency("NAD", getEth().getNamibia(), "Namibia", R.drawable.namibia));
        ethCurrencyList.add(new Currency("BRL", getEth().getBrazil(), "Brazil", R.drawable.brazil));
        ethCurrencyList.add(new Currency("ARS", getEth().getArgentina(), "Argentina", R.drawable.argentina));
        ethCurrencyList.add(new Currency("EGP", getEth().getEgypt(), "Egypt", R.drawable.egypt));
        ethCurrencyList.add(new Currency("ILS", getEth().getIsrael(), "Israel", R.drawable.israel));
        ethCurrencyList.add(new Currency("ZAR", getEth().getSouthAfrica(), "South Africa", R.drawable.southafrica));
        //ethCurrencyList.add(new Currency("MXN", getEth().getMexico()));
        ethCurrencyList.add(new Currency("RUB", getEth().getRussia(), "Russia", R.drawable.russia));
        ethCurrencyList.add(new Currency("EUR", getEth().getEuros(), "Euros", R.drawable.euros));

        return ethCurrencyList;
    }

}

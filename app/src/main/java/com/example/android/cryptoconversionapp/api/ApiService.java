package com.example.android.cryptoconversionapp.api;

import com.example.android.cryptoconversionapp.model.CurrencyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ETORO on 27/10/2017.
 */

public interface ApiService {



    @GET("/data/pricemulti?fsyms=BTC,ETH&tsyms=USD,GBP,CAD,CNY,INR,MYR,SGD,CHF,QAR,SEK,RWF,NGN,NAD,BRL,ARS,EGP,ILS,ZAR,RUB,EUR")
    Call<CurrencyResponse> getConversion();


//    @GET("data/pricemulti?")
//    Call<CurrencyResponse> getConversion(@Query("fsyms") String coins, @Query("tsyms") String currency);


}

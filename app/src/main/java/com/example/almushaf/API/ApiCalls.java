package com.example.almushaf.API;

import com.example.almushaf.API.Model.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCalls {


    @GET("radio/radio_ar.json")
    Call<RadiosResponse> getAllRadioChannels();


}

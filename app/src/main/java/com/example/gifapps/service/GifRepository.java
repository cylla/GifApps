package com.example.gifapps.service;

import com.example.gifapps.model.gif.GifDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GifRepository {
    @GET("v1/trending")
    Call<GifDiscoverResponse> getGifDiscover();
}

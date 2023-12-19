package com.example.afgetapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAf {
    @GET("api/discount-api/10021/2023-10-10?data-id=8390")
    Call<List<Afmodel>> getaf();
}
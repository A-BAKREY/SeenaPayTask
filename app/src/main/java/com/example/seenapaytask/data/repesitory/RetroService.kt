package com.example.seenapaytask.data.repesitory

import com.example.seenapaytask.di.RecycleModle
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface RetroService {

    @GET("viewed/{period}.json")
    fun getDataFromApi(
        @Query("period") period:Int,
        @Query("api-key")apiKey: String
    ): Call<RecycleModle>?
}
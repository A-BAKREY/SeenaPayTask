package com.example.seenapaytask.di.module

import com.example.seenapaytask.data.repesitory.RetroService
import com.example.seenapaytask.util.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetroModule {

    @Singleton
    @Provides
    fun getRetroService(retrofit: Retrofit) : RetroService {
        return retrofit.create(RetroService::class.java)
    }

    @Singleton
    @Provides
    fun getRetroInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}

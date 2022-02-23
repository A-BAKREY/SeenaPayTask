package com.example.seenapaytask.app

import android.app.Application
import com.example.seenapaytask.di.component.DaggerRetroComponent
import com.example.seenapaytask.di.component.RetroComponent
import com.example.seenapaytask.di.module.RetroModule


class MyAppliction: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()
        
        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}
package com.example.seenapaytask.di.component

import com.example.seenapaytask.presention.viewmodel.MainViewModel
import com.example.seenapaytask.di.module.RetroModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {


    fun inject(mainViewModel: MainViewModel)
}
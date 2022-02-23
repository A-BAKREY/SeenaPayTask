package com.example.seenapaytask.presention.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.seenapaytask.app.MyAppliction
import com.example.seenapaytask.di.RecycleModle
import com.example.seenapaytask.data.repesitory.RetroService
import com.example.seenapaytask.di.RecycleList
import com.example.seenapaytask.util.Constant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var mService: RetroService
    private var list: MutableLiveData<List<RecycleList>>

    init {
        (application as MyAppliction).getRetroComponent().inject(this)
        list = MutableLiveData()
    }

    fun getLiveDataObserve() : MutableLiveData<List<RecycleList>> {
        return list
    }

    fun makeApiCall(){
        val call: Call<RecycleModle>? = mService.getDataFromApi(Constant.PERIOD, Constant.API_KEY)

        call?.enqueue(object: Callback<RecycleModle>{
            override fun onResponse(call: Call<RecycleModle>, response: Response<RecycleModle>) {
                if (response.isSuccessful){
                    list.postValue(response.body()?.item)
                }else{
                    list.postValue(null)
                }
            }

            override fun onFailure(call: Call<RecycleModle>, t: Throwable) {
                list.postValue(null)
            }

        })
    }

}
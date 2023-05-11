package com.example.newsorg.viewmodel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsorg.model.source.ResponseDataSource
import com.example.newsorg.model.source.Source
import com.example.newsorg.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourceViewModel : ViewModel() {

    lateinit var liveDataSource : MutableLiveData<List<Source>?>

    init {
        liveDataSource = MutableLiveData()
    }

    fun getDataSource():MutableLiveData<List<Source>?> {
        return liveDataSource
    }

    fun callApiSource(category: String){
        ApiClient.instance.getAllSources(category).enqueue(object : Callback<ResponseDataSource>{
            override fun onResponse(
                call: Call<ResponseDataSource>,
                response: Response<ResponseDataSource>
            ) {
                if (response.isSuccessful){
                    liveDataSource.postValue(response.body()!!.sources)

                }else{
                    liveDataSource.postValue(null)
                }
            }

            override fun onFailure(call: Call<ResponseDataSource>, t: Throwable) {
                liveDataSource.postValue(null)
            }

        })
    }
}
package com.example.newsorg.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsorg.model.articel.Article
import com.example.newsorg.model.articel.ResponseArticles
import com.example.newsorg.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel : ViewModel() {

    lateinit var liveDataArticle : MutableLiveData<List<Article>>

    init {
        liveDataArticle = MutableLiveData()
    }

    fun getDataArticle() : MutableLiveData<List<Article>>{
        return liveDataArticle
    }

    fun callApiArticle(article : String){
        ApiClient.instance.gellAllArticles(article).enqueue(object : Callback<ResponseArticles>{
            override fun onResponse(
                call: Call<ResponseArticles>,
                response: Response<ResponseArticles>
            ) {

                if (response.isSuccessful){
                    liveDataArticle.postValue(response.body()!!.articles)
                }else{
                    liveDataArticle.postValue(null)
                }


            }

            override fun onFailure(call: Call<ResponseArticles>, t: Throwable) {

                liveDataArticle.postValue(null)

            }

        })

    }
}
package com.example.newsorg.network

import com.example.newsorg.model.articel.Article
import com.example.newsorg.model.articel.ResponseArticles
import com.example.newsorg.model.source.ResponseDataSource
import com.example.newsorg.model.source.Source
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines/sources")
    fun getAllSources(
        @Query("category") category : String,
        @Query("apiKey") apiKey : String = "9fdc48da878d45d79c0bc09860d72ac3"
    ) : Call<ResponseDataSource>

    @GET("top-headlines")
    fun gellAllArticles(
        @Query("sources") sources : String,
        @Query("apiKey") apiKey : String = "9fdc48da878d45d79c0bc09860d72ac3"
    ) : Call<ResponseArticles>
}
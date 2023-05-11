package com.example.newsorg.model.articel

import com.google.gson.annotations.SerializedName

data class ResponseArticles(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)

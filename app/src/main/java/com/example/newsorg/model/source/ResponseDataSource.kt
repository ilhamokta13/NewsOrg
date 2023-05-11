package com.example.newsorg.model.source


import com.example.newsorg.model.source.Source
import com.google.gson.annotations.SerializedName

data class ResponseDataSource(
    @SerializedName("sources")
    val sources: List<Source>,
    @SerializedName("status")
    val status: String
)
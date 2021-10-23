package com.nadhifa.movieapp.model.movie

import com.google.gson.annotations.SerializedName

data class MoviePopularItemResponse(

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("title", alternate = ["name"])
    val title: String
)

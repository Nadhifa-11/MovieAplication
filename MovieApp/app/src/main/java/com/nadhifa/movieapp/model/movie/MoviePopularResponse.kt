package com.nadhifa.movieapp.model.movie

import com.google.gson.annotations.SerializedName
import com.nadhifa.movieapp.model.movie.MoviePopularItemResponse

data class MoviePopularResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val result: ArrayList<MoviePopularItemResponse>
)
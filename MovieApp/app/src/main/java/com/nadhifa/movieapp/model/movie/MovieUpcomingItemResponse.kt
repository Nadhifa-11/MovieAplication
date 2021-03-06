package com.nadhifa.movieapp.model.movie

import com.google.gson.annotations.SerializedName

data class MovieUpcomingItemResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val result: ArrayList<MovieUpcomingResponse>
)
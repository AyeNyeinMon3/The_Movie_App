package com.example.movie.network.responses


import com.example.themovieapp.data.vos.GenreVO
import com.google.gson.annotations.SerializedName

data class GenreListResponse (
    @SerializedName("genres")
    val genres : List<GenreVO>
)
package com.example.themovieapp.network.responses

import com.example.themovieapp.data.vos.CastVO
import com.google.gson.annotations.SerializedName

data class CreditMovieResponse (

    @SerializedName("id")
    val id : Int,

    @SerializedName("cast")
    val cast : List<CastVO>,

    @SerializedName("crew")
    val crew : List<CastVO>


        )
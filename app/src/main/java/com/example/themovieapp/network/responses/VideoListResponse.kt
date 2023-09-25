package com.example.themovieapp.network.responses

import com.example.themovieapp.data.vos.VideoVO
import com.google.gson.annotations.SerializedName

data class VideoListResponse(

    @SerializedName("id")
    val id : Int,

    @SerializedName("results")
    val results : List<VideoVO>


)

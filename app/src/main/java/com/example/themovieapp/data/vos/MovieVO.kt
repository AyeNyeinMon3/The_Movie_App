package com.example.themovieapp.data.vos

import com.example.movie.data.vos.ProductionCompaniesVO
import com.example.movie.data.vos.ProductionCountriesVO
import com.example.movie.data.vos.SpokenLanguageVO
import com.google.gson.annotations.SerializedName

data class MovieVO(

    @SerializedName("adult")
    val adult : Boolean?,

    @SerializedName("backdrop_path")
    val backdropPath : String?,

    @SerializedName("budget")
    val budget : Int?,

    @SerializedName("genre_ids")
    val genreIds : List<Int>?,

    @SerializedName("genres")
    val genres : List<GenreVO>?,

    @SerializedName("homepage")
    val homepage : String?,

    @SerializedName("id")
    val id : Int = 0,

    @SerializedName("imdb_id")
    val imdbId : String?,

    @SerializedName("original_language")
    val originalLanguage : String?,

    @SerializedName("original_title")
    val originalTitle : String?,

    @SerializedName("overview")
    val overview : String?,

    @SerializedName("popularity")
    val popularity : Double?,

    @SerializedName("poster_path")
    val posterPath : String?,

    @SerializedName("production_companies")
    val productionCompanies : List<ProductionCompaniesVO>?,

    @SerializedName("production_countries")
    val productionCountries : List<ProductionCountriesVO>?,

    @SerializedName("revenue")
    val revenue : Int?,

    @SerializedName("runtime")
    val runtime : Int?,

    @SerializedName("spoken_languages")
    val spokenLanguage : List<SpokenLanguageVO>?,

    @SerializedName("status")
    val status : String?,

    @SerializedName("tagline")
    val tagLine : String?,

    @SerializedName("release_date")
    val releaseDate : String?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("video")
    val video : Boolean?,

    @SerializedName("vote_average")
    val voteAverage : Float?,

    @SerializedName("vote_count")
    val voteCount : Int?,

    ){
    fun getRatingBasedOnFiveStars() : Float {
        return voteAverage?.div(2)?.toFloat() ?: 0.0f
    }

    fun getGenresAsCommaSeparatedString() : String {
        return genres?.map { it.name }?.joinToString(", ") ?: ""
    }

    fun getDurationByMins():String{
         val min = runtime?.rem(60)
         return "$min m"
    }

    fun getDurationByHour():String{
        val hour = runtime?.div(60)
        return "$hour h"
    }


}

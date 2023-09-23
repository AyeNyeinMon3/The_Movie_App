package com.example.themovieapp.network

import com.example.movie.network.responses.GenreListResponse
import com.example.themovieapp.data.vos.GenreVO
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.data.vos.VideoVO
import com.example.themovieapp.network.responses.CreditMovieResponse
import com.example.themovieapp.network.responses.MovieListResponse
import com.example.themovieapp.network.responses.VideoListResponse
import com.example.themovieapp.utils.API_CREDIT_BY_MOVIE
import com.example.themovieapp.utils.API_GENRE_LIST
import com.example.themovieapp.utils.API_GET_NOW_PLAYING
import com.example.themovieapp.utils.API_MOVIES_BY_GENRE_ID
import com.example.themovieapp.utils.API_MOVIE_DETAILS
import com.example.themovieapp.utils.API_VIDEOS
import com.example.themovieapp.utils.MOVIE_API_KEY
import com.example.themovieapp.utils.PARAM_API_KEY
import com.example.themovieapp.utils.PARAM_GENRE_ID
import com.example.themovieapp.utils.PARAM_PAGE
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface TheMovieApi {

    @GET(API_GET_NOW_PLAYING)
    fun getNowPlaying(
        @Query(PARAM_API_KEY) apiKey : String = MOVIE_API_KEY,
        @Query(PARAM_PAGE) page : Int = 1,
    ) : Call<MovieListResponse>

    @GET("$API_MOVIE_DETAILS/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId : String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY
    ) : Call<MovieVO>

    @GET("$API_VIDEOS/{movie_id}/videos")
    fun getVideos(
        @Path("movie_id") movieId : String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY
    ) : Call<VideoVO>

    @GET(API_GENRE_LIST)
    fun getGenreList(
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY
    ):Call<GenreListResponse>

    @GET(API_MOVIES_BY_GENRE_ID)
    fun getMoviesByGenre(
        @Query(PARAM_GENRE_ID) genreId : String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY
    ):Call<MovieListResponse>

    @GET("$API_CREDIT_BY_MOVIE/{movie_id}/credits")
    fun getActors(
        @Path("movie_id") movieId: String,
        @Query(PARAM_API_KEY) apiKey: String = MOVIE_API_KEY
    ):Call<CreditMovieResponse>

}
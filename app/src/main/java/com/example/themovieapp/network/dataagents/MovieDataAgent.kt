package com.example.themovieapp.network.dataagents

import com.example.themovieapp.data.vos.CastVO
import com.example.themovieapp.data.vos.GenreVO
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.data.vos.VideoVO
import com.example.themovieapp.network.responses.VideoListResponse
import retrofit2.http.Query

interface MovieDataAgent{

    fun getNowPlaying(
        onSuccess : (List<MovieVO>) -> Unit,
        onFailure : (String) -> Unit

    )

    fun getMovieDetails(
        movieId : String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getVideos(
        movieId: String,
        onSuccess: (VideoVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getGenreList(
        onSuccess: (List<GenreVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getMoviesByGenre(
        genreId : String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getActors(
        movieId: String,
        onSuccess: (List<CastVO>) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSearchMovies(
        query: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    )

}
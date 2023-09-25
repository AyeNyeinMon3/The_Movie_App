package com.example.themovieapp.data.models

import androidx.lifecycle.LiveData
import com.example.themovieapp.data.vos.CastVO
import com.example.themovieapp.data.vos.GenreVO
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.data.vos.VideoVO
import io.reactivex.rxjava3.core.Observable

interface MovieModel {

    fun getNowPlaying(
        onFailure : (String) -> Unit
    ):LiveData<List<MovieVO>>?

    fun getMovieDetails(
        movieId : String,
        onFailure: (String) -> Unit
    ):LiveData<MovieVO?>?

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

    fun getSearchMovie(
        query : String,
        onFailure: (String) -> Unit
    ):Observable<List<MovieVO>>



}
package com.example.themovieapp.data.models

import com.example.themovieapp.data.vos.CastVO
import com.example.themovieapp.data.vos.GenreVO
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.data.vos.VideoVO
import com.example.themovieapp.network.dataagents.MovieDataAgent
import com.example.themovieapp.network.dataagents.RetrofitDataAgentImpl

object MovieModelImpl:MovieModel {

    private var mMovieDataAgent : MovieDataAgent = RetrofitDataAgentImpl

    override fun getNowPlaying(onSuccess: (List<MovieVO>) -> Unit, onFailure: (String) -> Unit) {

     mMovieDataAgent.getNowPlaying(
         onSuccess,
         onFailure
     )

    }

    override fun getMovieDetails(
        movieId: String,
        onSuccess: (MovieVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mMovieDataAgent.getMovieDetails(
            movieId,
            onSuccess,
            onFailure
        )
    }

    override fun getVideos(
        movieId: String,
        onSuccess: (VideoVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mMovieDataAgent.getVideos(
            movieId,
            onSuccess,
            onFailure
        )
    }

    override fun getGenreList(onSuccess: (List<GenreVO>) -> Unit, onFailure: (String) -> Unit) {
        mMovieDataAgent.getGenreList(
            onSuccess,
            onFailure
        )
    }

    override fun getMoviesByGenre(
        genreId: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mMovieDataAgent.getMoviesByGenre(
            genreId,
            onSuccess,
            onFailure
        )

    }

    override fun getActors(
        movieId: String,
        onSuccess: (List<CastVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mMovieDataAgent.getActors(
            movieId,
            onSuccess,
            onFailure
        )
    }


}
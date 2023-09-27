package com.example.themovieapp.data.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.example.themovieapp.data.vos.CastVO
import com.example.themovieapp.data.vos.GenreVO
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.data.vos.VideoVO
import com.example.themovieapp.utils.NOW_PLAYING
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

object MovieModelImpl:MovieModel,BaseModel() {


    @SuppressLint("CheckResult")
    override fun getNowPlaying(onFailure: (String) -> Unit): LiveData<List<MovieVO>>? {

        mMovieApi.getNowPlaying()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                it.result?.forEach { movie -> movie.type = NOW_PLAYING }
                mMovieDatabase?.movieDao()?.insertMovies(it.result ?: listOf())
            },
            {
                onFailure(it.localizedMessage ?: "")
            })
        return mMovieDatabase?.movieDao()?.getMovieByType(type = NOW_PLAYING)
    }

    @SuppressLint("CheckResult")
    override fun getMovieDetails(
        movieId: String,
        onFailure: (String) -> Unit
    ): LiveData<MovieVO?>? {
        mMovieApi.getMovieDetails(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val movieFromDatabaseToSync = mMovieDatabase?.movieDao()?.getMovieByIdOneTime(movieId = movieId.toInt())
                it.type = movieFromDatabaseToSync?.type
                mMovieDatabase?.movieDao()?.insertSingleMovie(it)


            },{
                onFailure(it.localizedMessage ?: "")
            })
        return mMovieDatabase?.movieDao()?.getMovieById(movieId = movieId.toInt())
    }

     @SuppressLint("CheckResult")
    override fun getVideos(
        movieId: String,
        onSuccess: (VideoVO) -> Unit,
        onFailure: (String) -> Unit
    ) {
        mMovieApi.getVideos(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(it)
            },
            {
                onFailure(it.localizedMessage ?: "")
            })

    }

     @SuppressLint("CheckResult")
    override fun getGenreList(onSuccess: (List<GenreVO>) -> Unit, onFailure: (String) -> Unit) {
       mMovieApi.getGenreList()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               onSuccess(it.genres)
           },
               {
                    onFailure(it.localizedMessage ?: "")
               })
    }

     @SuppressLint("CheckResult")
    override fun getMoviesByGenre(
        genreId: String,
        onSuccess: (List<MovieVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
       mMovieApi.getMoviesByGenre(genreId)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               onSuccess(it.result ?: listOf())
           },{
               onFailure(it.localizedMessage ?: "")
           })

    }

     @SuppressLint("CheckResult")
    override fun getActors(
        movieId: String,
        onSuccess: (List<CastVO>) -> Unit,
        onFailure: (String) -> Unit
    ) {
       mMovieApi.getActors(movieId)
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe({
               onSuccess(it.cast)
           },{
               onFailure(it.localizedMessage ?: "")
           })
    }


    override fun getSearchMovie(query: String): Observable<List<MovieVO>> {

        return mMovieApi
            .getSearchMovies(query = query)
            .map { it.result ?: listOf() }
            .onErrorResumeNext { Observable.just(listOf()) }
            .subscribeOn(Schedulers.io())
    }

    }


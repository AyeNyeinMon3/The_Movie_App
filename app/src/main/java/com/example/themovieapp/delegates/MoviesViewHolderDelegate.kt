package com.example.themovieapp.delegates

import androidx.recyclerview.widget.RecyclerView

interface MoviesViewHolderDelegate {

    fun onTapMovie(movieId : Int)

}
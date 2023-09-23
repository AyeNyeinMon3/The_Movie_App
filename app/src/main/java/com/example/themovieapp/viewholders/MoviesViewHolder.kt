package com.example.themovieapp.viewholders

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovieapp.R
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.delegates.MoviesViewHolderDelegate
import com.example.themovieapp.utils.IMAGE_BASE_URL

class MoviesViewHolder(itemView: View,private var delegate: MoviesViewHolderDelegate) : RecyclerView.ViewHolder(itemView) {

    private var mMovie : MovieVO? = null

    init {
        itemView.setOnClickListener {
            mMovie?.let {
                delegate.onTapMovie(it.id)
            }
        }
    }

    fun bindData(movie:MovieVO){

        mMovie = movie
        Glide.with(itemView.context)
            .load("$IMAGE_BASE_URL${movie.posterPath}")
            .into(itemView.findViewById(R.id.iv_poster))

        itemView.findViewById<TextView>(R.id.tv_movieName).text = movie.originalTitle
        itemView.findViewById<TextView>(R.id.tv_releaseYear).text = movie.releaseDate?.substring(0,4)
        itemView.findViewById<RatingBar>(R.id.ratingBar).rating = movie.getRatingBasedOnFiveStars()
        itemView.findViewById<TextView>(R.id.tv_voteAverage).text = movie.voteAverage.toString()


    }

}
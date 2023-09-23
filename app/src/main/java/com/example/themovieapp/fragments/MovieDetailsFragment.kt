package com.example.themovieapp.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.themovieapp.adapters.CastAdapter
import com.example.themovieapp.data.models.MovieModel
import com.example.themovieapp.data.models.MovieModelImpl
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.data.vos.VideoVO
import com.example.themovieapp.databinding.FragmentMovieDetailsBinding
import com.example.themovieapp.utils.IMAGE_BASE_URL

class MovieDetailsFragment:Fragment() {

    lateinit var binding: FragmentMovieDetailsBinding
    lateinit var mCastAdapter: CastAdapter

    private var mMovieModel : MovieModel = MovieModelImpl

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         return FragmentMovieDetailsBinding.inflate(inflater).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCastAdapter = CastAdapter()
        binding.rvCast.adapter = mCastAdapter


        val movieId = requireArguments().getInt("movieId").toString()
        requestData(movieId)

        binding.btnPlayTrailer.setOnClickListener {
            mMovieModel.getVideos(
                movieId = movieId,

                onSuccess = {
                    getTrailer(it)
                },
                onFailure = {

                }
            )
        }


    }

    private fun requestData(movieId : String){
        mMovieModel.getMovieDetails(
            movieId = movieId,

            onFailure = {

            },
            onSuccess = {
                bindData(it)
            }
        )

        mMovieModel.getActors(
            movieId,
            onSuccess = {
                mCastAdapter.setNewData(it)
            },
            onFailure = {

            }
        )


    }

    private fun bindData(movie : MovieVO){

        Glide.with(this)
            .load("$IMAGE_BASE_URL${movie.posterPath}")
            .into(binding.ivPoster)
        binding.tvMovieName.text = movie.originalTitle
        binding.tvReleaseYear.text = movie.releaseDate?.substring(0,4)
        binding.tvGenres.text = movie.getGenresAsCommaSeparatedString()
        binding.tvDurationHour.text = movie.getDurationByHour()
        binding.tvDurationMins.text = movie.getDurationByMins()
        binding.ratingBar.rating = movie.getRatingBasedOnFiveStars()
        binding.tvOverview.text = movie.overview

    }

    private fun getTrailer(video : VideoVO ) {

        val key = video.key

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v= $key"))
        startActivity(intent)

    }

}
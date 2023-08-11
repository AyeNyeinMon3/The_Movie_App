package com.example.themovieapp.fragments

import android.media.midi.MidiOutputPort
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.themovieapp.adapters.BannerAdapter
import com.example.themovieapp.adapters.GenresAdapter
import com.example.themovieapp.adapters.MoviesAdapter
import com.example.themovieapp.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var mBannerAdapter: BannerAdapter
    lateinit var mGenresAdapter: GenresAdapter
    lateinit var mMoviesAdapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  FragmentHomeBinding.inflate(inflater).also{
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBannerAdapter = BannerAdapter()
        binding.viewPagerBanner.adapter = mBannerAdapter

        mGenresAdapter = GenresAdapter()
        binding.rvGenres.adapter = mGenresAdapter

        mMoviesAdapter = MoviesAdapter()
        binding.rvMovies.adapter = mMoviesAdapter


    }

}
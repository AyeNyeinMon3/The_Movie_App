package com.example.themovieapp.fragments

import android.graphics.RenderEffect
import android.graphics.Shader
import android.media.midi.MidiOutputPort
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import com.example.themovieapp.adapters.BannerAdapter
import com.example.themovieapp.adapters.MoviesAdapter
import com.example.themovieapp.data.models.MovieModel
import com.example.themovieapp.data.models.MovieModelImpl
import com.example.themovieapp.data.vos.GenreVO
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.databinding.FragmentHomeBinding
import com.example.themovieapp.delegates.BannerViewHolderDelegate
import com.example.themovieapp.delegates.MoviesViewHolderDelegate
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class HomeFragment: Fragment(),MoviesViewHolderDelegate,BannerViewHolderDelegate {

    lateinit var binding: FragmentHomeBinding
    lateinit var mBannerAdapter: BannerAdapter
    lateinit var mMoviesAdapter: MoviesAdapter

    private var mMovieModel : MovieModel = MovieModelImpl
    private var mGenreList : List<GenreVO> = listOf()

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

        setUpRecyclerAdapter()

        setUpListeners()

        requestData()

//        //blur background effect
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
//            binding.chipNavBar.setRenderEffect(RenderEffect.createBlurEffect(30F, 30F,Shader.TileMode.MIRROR))
//        }



    }

    private fun setUpListeners(){
        binding.tabGenres.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                mGenreList?.get(tab?.position ?: 0)?.id?.let {

                    getMoviesByGenreId(it.toString())

                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }

    private fun setUpRecyclerAdapter() {
        mBannerAdapter = BannerAdapter(this)
        binding.rvBanner.adapter = mBannerAdapter


        mMoviesAdapter = MoviesAdapter(this)
        binding.rvMovies.adapter = mMoviesAdapter
    }

    private fun requestData() {
        mMovieModel.getNowPlaying(
            onSuccess = {
                mBannerAdapter.setNewData(it)

            },
            onFailure = {

            }
        )


        mMovieModel.getGenreList(
            onSuccess = {
                mGenreList = it
                setUpGenreTabLayout(it)

                it.firstOrNull()?.id?.let { genreId ->
                    getMoviesByGenreId(genreId.toString())
                }
            },
            onFailure = {

            }
        )
    }

     fun getMoviesByGenreId(genreId : String){
        mMovieModel.getMoviesByGenre(
            genreId,
            onSuccess = {
                mMoviesAdapter.setNewData(it)
            },
            onFailure = {

            }
        )
    }

    private fun setUpGenreTabLayout(genreList : List<GenreVO>){

        genreList.forEach {
            binding.tabGenres.newTab().apply {
                text = it.name
                binding.tabGenres.addTab(this)
            }
        }

    }




    override fun onTapMovie(movieId: Int) {
        view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(movieId))
    }

    override fun onTapBanner(id: Int) {

        view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(id))

//        findNavController().navigate(R.id.action_homeFragment_to_movieDetailsFragment,Bundle().apply {
//            putInt("movieId",id)
//        })



    }



}
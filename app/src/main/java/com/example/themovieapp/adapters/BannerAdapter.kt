package com.example.themovieapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import com.example.themovieapp.data.vos.MovieVO
import com.example.themovieapp.delegates.BannerViewHolderDelegate
import com.example.themovieapp.viewholders.BannerViewHolder

class BannerAdapter(private var delegate:BannerViewHolderDelegate): RecyclerView.Adapter<BannerViewHolder>() {

    private var mMovieList : List<MovieVO> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_banner,parent,false)
        return BannerViewHolder(view,delegate)
    }

    override fun getItemCount(): Int {
       return mMovieList.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        if (mMovieList.isNotEmpty()){
            holder.bindData(mMovieList[position])
        }


    }


  @SuppressLint("NotifyDataSetChanged")
  fun setNewData(movieList : List<MovieVO>){
      mMovieList = movieList
      notifyDataSetChanged()
  }

}
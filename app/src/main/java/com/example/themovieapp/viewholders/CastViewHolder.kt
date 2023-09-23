package com.example.themovieapp.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.themovieapp.R
import com.example.themovieapp.data.vos.CastVO
import com.example.themovieapp.utils.IMAGE_BASE_URL

class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var mCast : CastVO? = null

    fun bindData(cast : CastVO){

        mCast = cast

        Glide.with(itemView)
            .load("$IMAGE_BASE_URL${cast.profilePath}")
            .into(itemView.findViewById(R.id.imageView))

        itemView.findViewById<TextView>(R.id.cast_name).text = cast.name


    }



}
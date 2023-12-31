package com.example.themovieapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R
import com.example.themovieapp.data.vos.CastVO
import com.example.themovieapp.viewholders.CastViewHolder

class CastAdapter: RecyclerView.Adapter<CastViewHolder>() {

    private var mCastList : List<CastVO> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_cast,parent,false)
        return CastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mCastList.size
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        if (mCastList.isNotEmpty()){
            holder.bindData(mCastList[position])
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNewData(castList: List<CastVO>){
        mCastList = castList
        notifyDataSetChanged()
    }
}
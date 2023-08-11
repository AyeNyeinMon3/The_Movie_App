package com.example.themovieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.themovieapp.R


class GenresAdapter: RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_genres,parent,false)
        return GenresViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.bind()
        holder.itemView.isSelected = selectedPosition == position
    }


    inner class GenresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) , View.OnClickListener{


        init {

            itemView.setOnClickListener(this)
        }

        fun bind(){
            // Change text color based on the selected state
            if (selectedPosition == adapterPosition){
                itemView.findViewById<TextView>(R.id.tv_genre).setTextColor(itemView.context.resources.getColor(R.color.white))
            }else{
                itemView.findViewById<TextView>(R.id.tv_genre).setTextColor(itemView.context.resources.getColor(R.color.third_textColor))
            }
        }

        override fun onClick(view: View?) {

            val previousSelectedPosition = selectedPosition
            selectedPosition = adapterPosition
            notifyItemChanged(previousSelectedPosition)
            notifyItemChanged(selectedPosition)




        }

    }


}

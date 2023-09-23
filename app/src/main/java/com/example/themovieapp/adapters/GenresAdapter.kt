//package com.example.themovieapp.adapters
//
//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import android.widget.Toast
//import androidx.recyclerview.widget.RecyclerView
//import com.example.themovieapp.R
//import com.example.themovieapp.data.models.MovieModelImpl.getMoviesByGenre
//import com.example.themovieapp.data.vos.GenreVO
//import com.google.android.material.snackbar.Snackbar
//
//
//class GenresAdapter: RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {
//
//    private var selectedPosition = -1
//    private var mGenreList : List<GenreVO> = listOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_genres,parent,false)
//        return GenresViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return mGenreList.size
//    }
//
//    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
////        if (mGenreList.isNotEmpty()){
////            holder.bindData(mGenreList[position])
////        }
//        holder.bind(mGenreList[position])
//        holder.itemView.isSelected = selectedPosition == position
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun setNewData(genreList : List<GenreVO>){
//        mGenreList = genreList
//        notifyDataSetChanged()
//    }
//
//
//    inner class GenresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
//
//        private var mGenre : GenreVO? = null
//
//        init {
//
//            itemView.setOnClickListener(this)
//
//
//
//
//        }
//
//        fun bind(genre : GenreVO){
//
//            mGenre = genre
//
//            // Change text color based on the selected state
//            if (selectedPosition == adapterPosition){
//                itemView.findViewById<TextView>(R.id.tv_genre).setTextColor(itemView.context.resources.getColor(R.color.white))
//            }else{
//                itemView.findViewById<TextView>(R.id.tv_genre).setTextColor(itemView.context.resources.getColor(R.color.third_textColor))
//            }
//            itemView.findViewById<TextView>(R.id.tv_genre).text = genre.name
//
//        }
//
//
//        override fun onClick(view: View?) {
//
//            val previousSelectedPosition = selectedPosition
//            selectedPosition = adapterPosition
//            notifyItemChanged(previousSelectedPosition)
//            notifyItemChanged(selectedPosition)
//
//
//        }
//
//    }
//
//
//}

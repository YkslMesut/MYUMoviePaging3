package com.myu.myumoviepaging3.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myu.myumoviepagin3.databinding.RowMovieBinding
import com.myu.myumoviepagin3.BR
import com.myu.myumoviepaging3.data.entities.Movie

class MoviePagingAdapter : PagingDataAdapter<Movie,MoviePagingAdapter.MyViewHolder>(DIFF_UTIL) {

    var onClick : ((String) -> Unit)? = null

    inner class MyViewHolder(val viewDataBinding : RowMovieBinding) : RecyclerView.ViewHolder(viewDataBinding.root)

    companion object{
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.imdbID == newItem.imdbID
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun onMovieClick(listener : (String) -> Unit){
        onClick = listener
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)

        holder.viewDataBinding.setVariable(BR.movie,getItem(position))
        holder.viewDataBinding.root.setOnClickListener {
            onClick?.let {
                it(data?.imdbID!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val binding = RowMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

}
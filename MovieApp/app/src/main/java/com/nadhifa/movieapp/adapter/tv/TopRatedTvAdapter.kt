package com.nadhifa.movieapp.adapter.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nadhifa.movieapp.R
import com.nadhifa.movieapp.model.tv.TvTopRatedItemResponse
import kotlinx.android.synthetic.main.item_top_rated_tv.view.*

class TopRatedTvAdapter (var listTvTopRated: List<TvTopRatedItemResponse>) :
    RecyclerView.Adapter<TopRatedTvAdapter.TvTopRatedViewHolder>() {

    inner class TvTopRatedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tvTopRated: TvTopRatedItemResponse) {
            with(itemView)
            {
                Glide.with(context).load(BuildConfig.IMAGE_URL + tvTopRated.poster_path)
                    .into(iv_poster_top_rated_tv)
                tv_title_top_rated_tv.text = tvTopRated.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvTopRatedViewHolder {
        return TvTopRatedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_top_rated_tv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TvTopRatedViewHolder, position: Int) {
        holder.bind(listTvTopRated.get(position))
    }

    override fun getItemCount(): Int = listTvTopRated.size
}
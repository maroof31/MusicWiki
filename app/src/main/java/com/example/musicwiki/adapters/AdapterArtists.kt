package com.example.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ItemArtistBinding
import com.example.musicwiki.models.response.ArtistItem
import com.example.musicwiki.screens.activities.ArtistDetailActivity
import com.example.musicwiki.utils.showImage


class AdapterArtists(var mContext: Context) : RecyclerView.Adapter<AdapterArtists.GenreArtistsViewHolder>() {
    inner class GenreArtistsViewHolder(val binding: ItemArtistBinding) : RecyclerView.ViewHolder(binding.root)
    var genreArtists : List<ArtistItem> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreArtistsViewHolder {
        return GenreArtistsViewHolder(ItemArtistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GenreArtistsViewHolder, position: Int) {
        holder.binding.apply {
            itemArtistName.text = genreArtists[position].name
           // itemImg.showImage(genreArtists[position].image[0].text)
        }
        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, ArtistDetailActivity::class.java)
            mIntent.putExtra("AR-NAME",genreArtists[position].name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
       return genreArtists.size
    }
}
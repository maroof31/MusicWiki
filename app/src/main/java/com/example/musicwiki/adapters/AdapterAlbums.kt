package com.example.musicwiki.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.TopAlbumHorizontalItamBinding
import com.example.musicwiki.models.response.albums.AlbumItem
import com.example.musicwiki.screens.activities.AlbumDetailActivity
import com.example.musicwiki.utils.showImage

class AdapterAlbums(var mContext: Context) : RecyclerView.Adapter<AdapterAlbums.GenreAlbumsViewHolder>() {


inner class GenreAlbumsViewHolder(val binding : TopAlbumHorizontalItamBinding) : RecyclerView.ViewHolder(binding.root)

    var genreAlbums : List<AlbumItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAlbumsViewHolder {
        return GenreAlbumsViewHolder(
            TopAlbumHorizontalItamBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GenreAlbumsViewHolder, position: Int) {
        holder.binding.apply {
            itemText.text = genreAlbums[position].name
            itemArtistName.text = genreAlbums[position].artist.name
           itemImg.showImage(genreAlbums[position].image[0].text)
        //    Glide.with(mContext).load(genreAlbums[position].image[0]).into(itemImg);
        }

        holder.binding.root.setOnClickListener {
            val mIntent = Intent(mContext, AlbumDetailActivity::class.java)
            mIntent.putExtra("ANAME",genreAlbums[position].name)
            mIntent.putExtra("ARNAME",genreAlbums[position].artist.name)
            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
       return genreAlbums.size
    }


}
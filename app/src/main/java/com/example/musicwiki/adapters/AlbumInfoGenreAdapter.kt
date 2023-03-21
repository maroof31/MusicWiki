package com.example.musicwiki.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dhruv194.musicwiki.dataclasses.TagXX
import com.example.musicwiki.databinding.GenreItemBinding

class AlbumInfoGenreAdapter(var mContext: Context) : RecyclerView.Adapter<AlbumInfoGenreAdapter.AlbumInfoGenreViewHolder>() {
    inner class AlbumInfoGenreViewHolder(val binding: GenreItemBinding) : RecyclerView.ViewHolder(binding.root)

    var albumInfoGenre:List<TagXX> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumInfoGenreViewHolder {
        return AlbumInfoGenreViewHolder(
            GenreItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: AlbumInfoGenreViewHolder, position: Int) {
        holder.binding.apply {
            genreName.text = albumInfoGenre[position].name
        }
        holder.binding.root.setOnClickListener {
//            val mIntent = Intent(mContext, Ge::class.java)
//            mIntent.putExtra("NAME",albumInfoGenre[position].name)
//            mContext.startActivity(mIntent)
        }
    }

    override fun getItemCount(): Int {
      return  albumInfoGenre.size
    }
}
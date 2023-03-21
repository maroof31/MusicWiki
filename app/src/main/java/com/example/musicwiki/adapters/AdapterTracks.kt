package com.example.musicwiki.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.databinding.ItemArtistBinding
import com.example.musicwiki.models.response.toptracks.TrackItem
import com.example.musicwiki.utils.showImage

class AdapterTracks : RecyclerView.Adapter<AdapterTracks.GenreTracksViewHolder>() {
    inner class GenreTracksViewHolder(val binding: ItemArtistBinding) : RecyclerView.ViewHolder(binding.root)
    var genreTracks : List<TrackItem> = emptyList()

     val starUrl="https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreTracksViewHolder {
        return GenreTracksViewHolder(
            ItemArtistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GenreTracksViewHolder, position: Int) {

        holder.binding.apply {
            itemArtistName.setTextColor(Color.parseColor("#FF000000"))
            itemArtistName.text = genreTracks[position].name
            var imgUrl=genreTracks[position].image[0].text
            if(!(imgUrl==starUrl)) {
                itemImg.showImage(genreTracks[position].image[0].text)
            }
       //     Log.d("imageviewss",genreTracks[position].image[].text)
        }
    }

    override fun getItemCount(): Int {
        return genreTracks.size
    }
}
package com.example.musicwiki.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhruv194.musicwiki.dataclasses.AlbumXXX
import com.dhruv194.musicwiki.dataclasses.TrackXX
import com.example.musicwiki.models.response.ArtistItem
import com.example.musicwiki.models.response.albumInfo.Album
import com.example.musicwiki.models.response.albums.AlbumItem
import com.example.musicwiki.models.response.artistInfo.Artist
import com.example.musicwiki.models.response.genreInfo.Tagss
import com.example.musicwiki.models.response.genres.TagItem
import com.example.musicwiki.models.response.toptracks.TrackItem
import com.example.musicwiki.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _topTagResponse: MutableLiveData<List<TagItem>> = MutableLiveData()
    private val _tagInfoResponse : MutableLiveData<Tagss> = MutableLiveData()
    private val _tagTopAlbumsResponse : MutableLiveData<List<AlbumItem>> = MutableLiveData()
    private val _tagTopArtistsResposne : MutableLiveData<List<ArtistItem>> = MutableLiveData()
    private val _tagTopTracksResponse : MutableLiveData<List<TrackItem>> = MutableLiveData()
    private val _albumInfoResponse: MutableLiveData<Album> = MutableLiveData()
    private val _artistInfoResponse : MutableLiveData<Artist> = MutableLiveData()
    private val _artistTopAlbumsResponse : MutableLiveData<List<AlbumXXX>> = MutableLiveData()
    private val _artistTopTracksResponse : MutableLiveData<List<TrackXX>> = MutableLiveData()


    val topTagResponse : LiveData<List<TagItem>> = _topTagResponse
    val tagInfoResponse: LiveData<Tagss> = _tagInfoResponse
    val tagTopAlbumsResponse: LiveData<List<AlbumItem>> = _tagTopAlbumsResponse
    val tagTopArtistsResposne: LiveData<List<ArtistItem>> = _tagTopArtistsResposne
    val tagTopTracksResponse: LiveData<List<TrackItem>> = _tagTopTracksResponse
    val albumInfoResponse: LiveData<Album> = _albumInfoResponse
    val artistInfoResponse: MutableLiveData<Artist> = _artistInfoResponse
    val artistTopAlbumsResponse: LiveData<List<AlbumXXX>> = _artistTopAlbumsResponse
    val artistTopTracksResponse: LiveData<List<TrackXX>> = _artistTopTracksResponse

    init {
        reloadTopTags()
    }
    private fun reloadTopTags(){
        viewModelScope.launch {
            val response = repository.getTopTags()
            if(response.isSuccessful){
                _topTagResponse.value = response.body()!!.toptags.tag
                Log.d("responses",response.toString())
            }
        }
    }

    fun getTagInfo(tag : String){
        viewModelScope.launch {
            val response = repository.getTagInfo(tag)
            if(response.isSuccessful){
                _tagInfoResponse.value = response.body()!!.tag
            }
        }
    }

    fun getTagTopAlbums(tag:String){
        viewModelScope.launch {
            val response = repository.getTagAlbum(tag)
            if (response.isSuccessful){
                _tagTopAlbumsResponse.value = response.body()!!.albums.album
            }

        }
    }

    fun getTagTopArtists(tag:String){
        viewModelScope.launch {
            val response = repository.getTagArtist(tag)
            if(response.isSuccessful){
                _tagTopArtistsResposne.value = response.body()!!.topartists.artist
            }

        }
    }

    fun getTagTopTracks(tag: String){
        viewModelScope.launch {
            val response= repository.getTagTracks(tag)
            if(response.isSuccessful){
                _tagTopTracksResponse.value = response.body()!!.tracks.track
            }
        }
    }



    fun getAlbumInfo(artist:String, album:String){
        viewModelScope.launch {
            val response = repository.getAlbumInfo(artist, album)
            if (response.isSuccessful){
                _albumInfoResponse.value = response.body()!!.album
            }

        }
    }

    fun getArtistInfo(artist: String){
        viewModelScope.launch {
            val response = repository.getArtistInfo(artist)
            if (response.isSuccessful){
                _artistInfoResponse.value = response.body()!!.artist
            }

        }
    }



    fun getArtistTopAlbums(artist:String){
        viewModelScope.launch{
            val response = repository.getArtistTopAlbums(artist)
            if (response.isSuccessful){
                _artistTopAlbumsResponse.value = response.body()!!.topalbums.album
            }

        }
    }


    fun getArtistTopTracks(artist:String){
        viewModelScope.launch{
            val response = repository.getArtistTopTracks(artist)
            if(response.isSuccessful){
                _artistTopTracksResponse.value = response.body()!!.toptracks.track
            }
        }
    }


}
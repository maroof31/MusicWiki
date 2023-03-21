package com.example.musicwiki.repository

import com.dhruv194.musicwiki.dataclasses.artistTopAlbums
import com.dhruv194.musicwiki.dataclasses.artistTopTracks
import com.example.musicwiki.Api.RetrofitInstance
import com.example.musicwiki.models.response.TopArtistsModel
import com.example.musicwiki.models.response.albumInfo.AlbumInfomodel
import com.example.musicwiki.models.response.albums.AlbumsModel
import com.example.musicwiki.models.response.artistInfo.ArtistInfoModel
import com.example.musicwiki.models.response.artistTopAlbum.ArtistTopAlbumModel
import com.example.musicwiki.models.response.genreInfo.GenreInfoResponse
import com.example.musicwiki.models.response.genres.Genres
import com.example.musicwiki.models.response.toptracks.TopTracksModel
import retrofit2.Response



class Repository {

    suspend fun getTopTags(): Response<Genres> {
        return RetrofitInstance.api.getTopTags()
    }

    suspend fun getTagInfo(tag:String): Response<GenreInfoResponse> {
        return RetrofitInstance.api.getTagInfo(tag)
    }

    suspend fun getTagAlbum(tag:String): Response<AlbumsModel> {
        return RetrofitInstance.api.getTopAlbums(tag)
    }

    suspend fun getTagArtist(tag:String): Response<TopArtistsModel> {
        return RetrofitInstance.api.getTopArtists(tag)
    }

    suspend fun getTagTracks(tag: String): Response<TopTracksModel> {
        return RetrofitInstance.api.getTopTracks(tag)
    }

    suspend fun getAlbumInfo(artist:String, album:String): Response<AlbumInfomodel> {
        return RetrofitInstance.api.getAlbumInfo(artist, album )
    }

    suspend fun getArtistInfo(artist: String): Response<ArtistInfoModel> {
        return RetrofitInstance.api.getArtistInfo(artist)
    }


    suspend fun getArtistTopAlbums(artist: String):Response<artistTopAlbums>{
        return RetrofitInstance.api.getArtistTopAlbums(artist)
    }
    suspend fun getArtistTopTracks(artist: String): Response<artistTopTracks> {
        return RetrofitInstance.api.getArtistTopTracks(artist)
    }
}
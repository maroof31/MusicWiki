package com.example.musicwiki.models.response.artistTopAlbum

import com.google.gson.annotations.SerializedName

data class ArtistTopAlbumModel(

	@field:SerializedName("topalbums")
	val topalbums: Topalbums? = null
)

data class Attr(

	@field:SerializedName("total")
	val total: String? = null,

	@field:SerializedName("perPage")
	val perPage: String? = null,

	@field:SerializedName("artist")
	val artist: String? = null,

	@field:SerializedName("totalPages")
	val totalPages: String? = null,

	@field:SerializedName("page")
	val page: String? = null
)

data class Topalbums(

	@field:SerializedName("@attr")
	val attr: Attr? = null,

	@field:SerializedName("album")
	val album: List<AlbumItem?>? = null
)

data class AlbumItem(

	@field:SerializedName("image")
	val image: List<ImageItem?>? = null,

	@field:SerializedName("artist")
	val artist: Artist? = null,

	@field:SerializedName("playcount")
	val playcount: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("mbid")
	val mbid: String? = null
)

data class ImageItem(

	@field:SerializedName("#text")
	val text: String? = null,

	@field:SerializedName("size")
	val size: String? = null
)

data class Artist(

	@field:SerializedName("mbid")
	val mbid: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

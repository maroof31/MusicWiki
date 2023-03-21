package com.example.musicwiki.models.response

import com.google.gson.annotations.SerializedName

data class TopArtistsModel(

	@field:SerializedName("topartists")
	val topartists: Topartists
)

data class Attr(

	@field:SerializedName("total")
	val total: String,

	@field:SerializedName("perPage")
	val perPage: String,

	@field:SerializedName("totalPages")
	val totalPages: String,

	@field:SerializedName("tag")
	val tag: String,

	@field:SerializedName("page")
	val page: String,

	@field:SerializedName("rank")
	val rank: String
)

data class Topartists(

	@field:SerializedName("@attr")
	val attr: Attr,

	@field:SerializedName("artist")
	val artist: List<ArtistItem>
)

data class ArtistItem(

	@field:SerializedName("image")
	val image: List<ImageItem>,

	@field:SerializedName("@attr")
	val attr: Attr,

	@field:SerializedName("mbid")
	val mbid: String,

	@field:SerializedName("streamable")
	val streamable: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class ImageItem(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("size")
	val size: String
)

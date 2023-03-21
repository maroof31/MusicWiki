package com.example.musicwiki.models.response.toptracks

import com.google.gson.annotations.SerializedName

data class TopTracksModel(
	@field:SerializedName("tracks")
	val tracks: Tracks
)

data class TrackItem(

	@field:SerializedName("duration")
	val duration: String,

	@field:SerializedName("image")
	val image: List<ImageItem>,

	@field:SerializedName("@attr")
	val attr: Attr,

	@field:SerializedName("mbid")
	val mbid: String,

	@field:SerializedName("streamable")
	val streamable: Streamable,

	@field:SerializedName("artist")
	val artist: Artist,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
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

data class ImageItem(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("size")
	val size: String
)

data class Streamable(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("fulltrack")
	val fulltrack: String
)

data class Tracks(

	@field:SerializedName("@attr")
	val attr: Attr,

	@field:SerializedName("track")
	val track: List<TrackItem>
)

data class Artist(

	@field:SerializedName("mbid")
	val mbid: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

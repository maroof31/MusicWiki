package com.example.musicwiki.models.response.albumInfo

import com.google.gson.annotations.SerializedName

data class AlbumInfomodel(

	@field:SerializedName("album")
	val album: Album
)

data class Tracks(

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

data class Attr(

	@field:SerializedName("rank")
	val rank: Int
)

data class Wiki(

	@field:SerializedName("summary")
	val summary: String,

	@field:SerializedName("published")
	val published: String,

	@field:SerializedName("content")
	val content: String
)

data class Streamable(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("fulltrack")
	val fulltrack: String
)

data class TagItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class Album(
	@field:SerializedName("image")
	val image: List<ImageItem>,

	@field:SerializedName("mbid")
	val mbid: String,

	@field:SerializedName("listeners")
	val listeners: String,

	@field:SerializedName("artist")
	val artist: String,

	@field:SerializedName("playcount")
	val playcount: String,

	@field:SerializedName("wiki")
	val wiki: Wiki,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("tracks")
	val tracks: Tracks,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("tags")
	val tags: Tags
)

data class Tags(

	@field:SerializedName("tag")
	val tag: List<TagItem>
)

data class ImageItem(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("size")
	val size: String
)

data class TrackItem(

	@field:SerializedName("duration")
	val duration: Any,

	@field:SerializedName("@attr")
	val attr: Attr,

	@field:SerializedName("streamable")
	val streamable: Streamable,

	@field:SerializedName("artist")
	val artist: Artist,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

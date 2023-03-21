package com.example.musicwiki.models.response.artistInfo

import com.google.gson.annotations.SerializedName

data class ArtistInfoModel(

	@field:SerializedName("artist")
	val artist: Artist
)

data class Similar(

	@field:SerializedName("artist")
	val artist: List<ArtistItem>
)

data class Links(

	@field:SerializedName("link")
	val link: Link
)

data class Tags(

	@field:SerializedName("tag")
	val tag: List<TagItem>
)

data class TagItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class Link(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("rel")
	val rel: String,

	@field:SerializedName("href")
	val href: String
)

data class ArtistItem(

	@field:SerializedName("image")
	val image: List<ImageItem>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class Bio(

	@field:SerializedName("summary")
	val summary: String,

	@field:SerializedName("links")
	val links: Links,

	@field:SerializedName("published")
	val published: String,

	@field:SerializedName("content")
	val content: String
)

data class ImageItem(

	@field:SerializedName("#text")
	val text: String,

	@field:SerializedName("size")
	val size: String
)

data class Artist(

	@field:SerializedName("image")
	val image: List<ImageItem>,

	@field:SerializedName("similar")
	val similar: Similar,

	@field:SerializedName("mbid")
	val mbid: String,

	@field:SerializedName("streamable")
	val streamable: String,

	@field:SerializedName("stats")
	val stats: Stats,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("ontour")
	val ontour: String,

	@field:SerializedName("bio")
	val bio: Bio,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("tags")
	val tags: Tags
)

data class Stats(

	@field:SerializedName("listeners")
	val listeners: String,

	@field:SerializedName("playcount")
	val playcount: String
)

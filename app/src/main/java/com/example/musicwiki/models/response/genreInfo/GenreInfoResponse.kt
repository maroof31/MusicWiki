package com.example.musicwiki.models.response.genreInfo

import com.google.gson.annotations.SerializedName

data class GenreInfoResponse(

	@field:SerializedName("tag")
	val tag: Tagss
)

data class Wiki(

	@field:SerializedName("summary")
	val summary: String,

	@field:SerializedName("content")
	val content: String
)

data class Tagss(

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("reach")
	val reach: Int,

	@field:SerializedName("wiki")
	val wiki: Wiki,

	@field:SerializedName("name")
	val name: String
)

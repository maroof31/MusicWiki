package com.example.musicwiki.models.response.genres

import com.google.gson.annotations.SerializedName

data class Genres(

	@field:SerializedName("toptags")
	val toptags: Toptags
)

data class TagItem(

	@field:SerializedName("reach")
	val reach: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("count")
	val count: Int
)

data class Attr(

	@field:SerializedName("total")
	val total: Int,

	@field:SerializedName("offset")
	val offset: Int,

	@field:SerializedName("num_res")
	val numRes: Int
)

data class Toptags(

	@field:SerializedName("@attr")
	val attr: Attr,

	@field:SerializedName("tag")
	val tag: List<TagItem>
)

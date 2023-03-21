package com.dhruv194.musicwiki.dataclasses


data class Bio(
    val content: String,
    val links: Links,
    val published: String,
    val summary: String
)
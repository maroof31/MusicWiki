package com.example.musicwiki.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.musicwiki.R

fun ImageView.showImage(url :String?){
    val option = RequestOptions().placeholder(R.drawable.artist).error(R.drawable.artist)
    Glide.with(context).setDefaultRequestOptions(option).load(url).into(this)

}
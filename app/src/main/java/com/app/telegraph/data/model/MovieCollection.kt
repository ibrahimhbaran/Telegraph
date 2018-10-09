package com.app.telegraph.data.model

import com.google.gson.annotations.SerializedName

data class MovieCollection(@SerializedName("collection") var collection: List<Movie>)
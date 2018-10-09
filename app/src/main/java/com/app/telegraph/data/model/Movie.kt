package com.app.telegraph.data.model

import com.google.gson.annotations.SerializedName

data class Movie(@field:SerializedName("id") var id: Int,
                 @field:SerializedName("headline") var headline: String,
                 @field:SerializedName("picture-url") var picture_url: String,
                 @field:SerializedName("synopsis") var synopsis: String,
                 @field:SerializedName("ratings") var ratings: String,
                 @field:SerializedName("actors") var actors: List<String>,
                 @field:SerializedName("genre") var genre: List<String>,
                 @field:SerializedName("director") var director: String,
                 @field:SerializedName("release-date") var release_date: String
)


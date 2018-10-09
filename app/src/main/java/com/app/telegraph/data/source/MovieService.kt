package com.app.telegraph.data.source

import com.app.telegraph.data.model.MovieCollection

import io.reactivex.Observable
import retrofit2.http.GET

interface MovieService {
    @GET("articles.json")
    fun getMovies(): Observable<MovieCollection>
}
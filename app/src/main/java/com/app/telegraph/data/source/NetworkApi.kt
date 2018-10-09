package com.app.telegraph.data.source

import com.app.telegraph.utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 *  Network API for fetching data from remote data source
 */
class NetworkApi {

    companion object MovieApi {
        fun create(): MovieService {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(MovieService::class.java)
        }
    }

}
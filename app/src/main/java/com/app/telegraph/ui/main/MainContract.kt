package com.app.telegraph.ui.main

import com.app.telegraph.data.model.Movie
import com.app.telegraph.data.source.MovieService
import com.app.telegraph.ui.base.BaseContract

class MainContract {

    // presenter contract
    interface Presenter : BaseContract.Presenter<MainContract.View>
    {
        fun loadData(service: MovieService)
    }

    // view contract for MainActivity class , we will show a progress bar during data load , if any error happens  it will show error message .
    interface View : BaseContract.View{

        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(list: List<Movie>)

    }

}
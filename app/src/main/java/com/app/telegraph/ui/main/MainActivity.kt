package com.app.telegraph.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.View
import com.app.telegraph.R
import com.app.telegraph.data.model.Movie
import com.app.telegraph.data.source.MovieService
import com.app.telegraph.utils.ItemDecorator
import com.app.telegraph.utils.ViewUtils
import com.app.telegraph.utils.telegraphApp
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }

    @Inject
    lateinit var mainPresenter: MainPresenter

    @Inject
    lateinit var apiService: MovieService


    private val moviesAdapter: MoviesAdapter = MoviesAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        telegraphApp.component.inject(this)

        mainPresenter.attach(this)

        mainPresenter.loadData(apiService,Schedulers.io(),AndroidSchedulers.mainThread())


    }


    override fun showProgress(show: Boolean) {

        if (show) {
            progress.visibility = View.VISIBLE
        } else {

            progress.visibility = View.GONE
        }

    }

    override fun showErrorMessage(error: String) {

        Log.v(TAG, error)
    }

    override fun loadDataSuccess(movieList: List<Movie>) {

        moviesAdapter.updateMovies(movieList)
    }


    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.unsubscribe()
        mainPresenter.detach()
    }

    private fun initViews() {
        val gridColumnsSize = ViewUtils.calculateNoOfColumns(this)
        val gridLayoutManager = GridLayoutManager(this,gridColumnsSize)
        val itemDecorator = ItemDecorator(10, gridColumnsSize)
        moviesRV.layoutManager = gridLayoutManager
        moviesRV.addItemDecoration(itemDecorator)
        moviesRV.adapter = moviesAdapter

    }


}

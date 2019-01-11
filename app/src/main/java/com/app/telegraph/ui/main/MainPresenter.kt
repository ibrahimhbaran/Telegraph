package com.app.telegraph.ui.main

import com.app.telegraph.data.source.MovieService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * presenter class that will be used in Main activity , winn interact between model and view
 */
class MainPresenter : MainContract.Presenter {

    private val mDisposable = CompositeDisposable()

    private var view: MainContract.View? = null

    // presenter method communicates with model
    override fun loadData(service: MovieService, processScheduler: Scheduler,  androidScheduler: Scheduler) {

        mDisposable.add(service.getMovies().subscribeOn(processScheduler).observeOn(androidScheduler)
                .doOnSubscribe {
                    view?.showProgress(true)
                }
                .subscribe({
                    view?.showProgress(false)
                    view?.loadDataSuccess(it.collection)
                }, {
                    view?.showProgress(false)
                    view?.showErrorMessage(it.localizedMessage)
                }))
    }


    /**
     * this method will do unsubscribe for disposable rx object
     */
    override fun unsubscribe() {

        mDisposable.clear()
    }


    /**
     *  attach our view to the presenter
     */
    override fun attach(view: MainContract.View) {
        this.view = view
    }

   // on destroy ccall this for preventing memory leaks
    override fun detach() {
        if(this.view != null)
        {
            this.view = null
        }
    }


}
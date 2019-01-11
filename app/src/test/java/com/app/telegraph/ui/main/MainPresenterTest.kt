package com.app.telegraph.ui.main

import com.app.telegraph.data.model.Movie
import com.app.telegraph.data.model.MovieCollection
import com.app.telegraph.data.source.MovieService
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import io.reactivex.schedulers.TestScheduler
import org.mockito.Mockito.`when`



class MainPresenterTest {

    @Mock
    lateinit var mockService: MovieService

    @Mock
    lateinit var view: MainContract.View



    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

    }

    @Test
    fun test_LoadData() {

        val mainPresenter = MainPresenter()

        mainPresenter.attach(view)

        val movie1 = Movie(1,"Test Movie","","", "", listOf(""), listOf(""),"","")


        `when`(mockService.getMovies()).thenReturn(Observable.just(MovieCollection(listOf(movie1))))


        val scheduler = TestScheduler()

         mainPresenter.loadData(mockService, scheduler,scheduler)

         scheduler.triggerActions()

         verify(view).loadDataSuccess(listOf(movie1))


    }

}
package com.app.telegraph.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.app.telegraph.R
import com.app.telegraph.data.model.Movie
import com.app.telegraph.utils.GlideApp


/**
 * Adapter for the list of the movies
 * @property context Context in which the application is running
 */
class MoviesAdapter(private val context: Context) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    /**
     * The list of posts of the adapter
     */
    private var movieList: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        movieViewHolder.bind(movieList[position])
    }


    override fun getItemCount() = movieList.size


    /**
     * Updates the list of movies of the adapter
     * @param movies the new list of movies of the adapter
     */
    fun updateMovies(movies: List<Movie>) {
        this.movieList = movies
        notifyDataSetChanged()
    }

    /**
     * The ViewHolder of the adapter
     *
     */
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvHeadLine = itemView.findViewById<TextView>(R.id.tv_headline)
        private val imgPoster = itemView.findViewById<ImageView>(R.id.img_movie_poster)
        private val tvGenreYear = itemView.findViewById<TextView>(R.id.tv_movie_genre_year)
        private val tvSynopsis = itemView.findViewById<TextView>(R.id.tv_synopsis)

        fun bind(movie: Movie) {

            tvHeadLine.text = movie.headline
            tvGenreYear.text = "${movie.genre + "/" + movie.release_date}"
            tvSynopsis.text = movie.synopsis
            GlideApp.with(itemView.context)
                    .load(movie.picture_url.replace("http", "https")) // http url not works might be server issue , https is ok
                    .placeholder(itemView.context.resources.getDrawable(R.drawable.placeholder))
                    .centerCrop()
                    .into(imgPoster)


        }
    }
}

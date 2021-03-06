package com.nadhifa.movieapp.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nadhifa.movieapp.R
import com.nadhifa.movieapp.adapter.movie.PopularMovieAdapter
import com.nadhifa.movieapp.adapter.movie.UpcomingMovieAdapter
import com.nadhifa.movieapp.model.movie.MoviePopularItemResponse
import com.nadhifa.movieapp.model.movie.MovieUpcomingResponse
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel
    private lateinit var popularMovieAdapter: PopularMovieAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_movie, container, false)

        movieViewModel =
            ViewModelProvider(this).get(MovieViewModel::class.java)

        // Popular
        movieViewModel.init(1)
        movieViewModel.getData().observe(viewLifecycleOwner, Observer { popularMovie ->
            getInitPopular(popularMovie)
        })

        // Upcoming
        movieViewModel.initUp(1)
        movieViewModel.getDataUpcoming().observe(viewLifecycleOwner, Observer { movieUpcoming ->
            getInitUpcoming(movieUpcoming)
        })

        return root
    }

    private fun getInitUpcoming(movieMovieUpcoming: List<MovieUpcomingResponse>) {
        rv_upcoming_movie.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            upcomingMovieAdapter =
                UpcomingMovieAdapter(
                    movieMovieUpcoming
                )
            rv_upcoming_movie.adapter = upcomingMovieAdapter
        }
    }

    private fun getInitPopular(popularMoviePopular: List<MoviePopularItemResponse>) {
        // Asyncronus
        rv_popular_movie.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            popularMovieAdapter =
                PopularMovieAdapter(
                    popularMoviePopular
                )
            rv_popular_movie.adapter = popularMovieAdapter
        }
    }
}
package com.rubens.services;

import com.rubens.apis.OmdbApi;
import com.rubens.daos.MovieDAO;
import com.rubens.models.Movie;

import java.sql.Connection;

public class MoviesService {
    public void searchMovie(String title, Connection connection) {
        OmdbApi omdbSearch = new OmdbApi();
        var movie = omdbSearch.searchMovie(title);
        addMovie(movie, connection);
    }

    public void addMovie(Movie movie, Connection connection){
        MovieDAO movieDAO = new MovieDAO(connection);
        movieDAO.add(movie);

        System.out.println("Movie added: " + movie.getTitle());
    }

    public void showAllMovies(Connection connection) {
        MovieDAO movieDAO = new MovieDAO(connection);
        System.out.println("Movies in our database:");

        movieDAO.getAll().forEach(movieData -> {
            System.out.println(movieData.getTitle());
        });
    }

    public void demo(String title, Connection connection) {
        searchMovie(title, connection);
        showAllMovies(connection);
    }
}

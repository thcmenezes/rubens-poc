package com.rubens.daos;

import com.rubens.models.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Set;

public class MovieDAO {
    private Connection connection;

    public MovieDAO(Connection database) {
        this.connection = database;
    }

    public Set<Movie> getAll() {
        Set<Movie> movies = new HashSet<>();

        String sqlQuery = "SELECT * from movies";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet results = preparedStatement.executeQuery();

            while (results.next()) {
                Movie movie = new Movie(results.getString(2), results.getString(4));

                movies.add(movie);
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return movies;
    }
    public void add(Movie movie) {
        String sqlQuery = "INSERT INTO movies (title)" + "VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, movie.getTitle());

            if (preparedStatement.execute()) {
                System.out.println("Movie added");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Movie movie) {
        PreparedStatement preparedStatement;
        String sqlQuery = "DELETE from movies WHERE title = ?";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, movie.getTitle());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void watch(Movie movie) {
        PreparedStatement preparedStatement;
        String sqlQuery = "UPDATE movies SET watched = ? WHERE title = ?";

        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setBoolean(1, movie.isWatched());
            preparedStatement.setString(2, movie.getTitle());

            preparedStatement.execute();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

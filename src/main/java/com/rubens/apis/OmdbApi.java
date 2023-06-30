package com.rubens.apis;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rubens.configs.EnvConfig;
import com.rubens.models.Movie;
import com.rubens.records.OmdbMovie;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class OmdbApi {

    public HttpResponse<String> requestForAMovie(String movieTitle) {
        String encondeInput = URLEncoder.encode(movieTitle, StandardCharsets.UTF_8);
        URI uriOmdb = URI.create(EnvConfig.getValueByKey("OMDB_URI") + encondeInput);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uriOmdb)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Cannot find this movie.");
        }
    }
    public Movie searchMovie(String movieTitle) {
        var responseForAMovie = requestForAMovie(movieTitle);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        OmdbMovie omdbMovie = gson.fromJson(responseForAMovie.body(), OmdbMovie.class);

        System.out.println(responseForAMovie.body());

        Movie movie = new Movie(omdbMovie);

        return movie;
    }
}

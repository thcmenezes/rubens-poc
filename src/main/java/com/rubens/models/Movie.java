package com.rubens.models;

import com.google.gson.annotations.SerializedName;
import com.rubens.records.OmdbMovie;

import java.util.Date;
import java.util.List;

public class Movie {
    private String title;
    private Date releaseDate;
    private boolean watched;
    private String director;
    private String plot;
    private Url url;
    private Url posterUrl;
    private List<Category> categories;

    public Movie (String title, String director) {
        this.title = title;
        this.director = director;
    }

    public Movie (OmdbMovie omdbMovie) {
        this.title = omdbMovie.title();
    }

    public String getTitle() {
        return title;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public boolean isWatched() {
        return watched;
    }
    public String getDirector() {
        return director;
    }
    public String getPlot() {
        return plot ;
    }
    public String getUrl() {
        return url.getLink();
    }
    public String getPosterUrl() {
        return posterUrl.getLink();
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public void watch(boolean watched) {
        this.watched = watched;
    }
    public void setPlot(String plot) {
        this.plot  = plot;
    }
    public void setUrl(String url) {
        this.url.setLink(url);
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl.setLink(posterUrl);
    }

    public void addNomination(Category category){
        categories.add(category);
    }
    public List<Category> getNominations() {
        return categories;
    }
}
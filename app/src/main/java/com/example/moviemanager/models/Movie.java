package com.example.moviemanager.models;

import java.io.Serializable;

public class Movie implements Serializable {

    String id;
    String title;
    String overview;
    float voteAverage;
    float voteCount;
    String posterPath;
    String backdropPath;

    public Movie(String _id, String _title, String _overview, float _voteAverage, float _voteCount, String _posterPath, String _backdropPath) {
        this.id = _id;
        this.title = _title;
        this.overview = _overview;
        this.voteAverage = _voteAverage;
        this.voteCount = _voteCount;
        this.posterPath = _posterPath;
        this.backdropPath = _backdropPath;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return this.overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getVoteAverage() {
        return this.voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public float getVoteCount() {
        return this.voteCount;
    }

    public void setVoteCount(float voteCount) {
        this.voteCount = voteCount;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", this.posterPath);
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w780%s", this.backdropPath);
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
}

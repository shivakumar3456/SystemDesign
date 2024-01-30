package com.bookmyshow.movie;


public class Movie {

    int id;
    String movieName;
    int movieDurationInMinutes;

    public int getMovieId() {
        return id;
    }

    public void setMovieId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieDuration() {
        return movieDurationInMinutes;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDurationInMinutes = movieDuration;
    }
}


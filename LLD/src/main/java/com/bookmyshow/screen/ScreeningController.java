package com.bookmyshow.screen;

import com.bookmyshow.City;
import com.bookmyshow.movie.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ScreeningController {

    Map<City, List<Movie>> cityToMovieMap;
    List<Movie> allMovies;

    public ScreeningController() {
        cityToMovieMap = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city) {

        allMovies.add(movie);

        List<Movie> movies = cityToMovieMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityToMovieMap.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {

        for (Movie movie : allMovies) {
            if ((movie.getMovieName()).equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMoviesByCity(City city) {
        return cityToMovieMap.get(city);
    }

    boolean removeMovieFromCity(City city, Movie movie) {
        List<Movie> movies = cityToMovieMap.get(city);
        if (movies == null || movies.isEmpty()) {
            return false;
        }
        return movies.remove(movie);
    }

}

package com.bookmyshow;

import com.bookmyshow.movie.Movie;
import com.bookmyshow.movie.Show;
import com.bookmyshow.screen.Screen;
import com.bookmyshow.screen.ScreeningController;
import com.bookmyshow.screen.Seat;
import com.bookmyshow.screen.SeatCategory;
import com.bookmyshow.theater.Theater;
import com.bookmyshow.theater.TheaterController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Admin {
    private ScreeningController screeningController;
    private TheaterController theaterController;

    public Admin() {
        screeningController = new ScreeningController();
        theaterController = new TheaterController();
    }

    public void init() {
        createMovies();
        createTheater();
    }

    private void createTheater() {

        Movie movie2 = screeningController.getMovieByName("MOVIE2");
        Movie movie1 = screeningController.getMovieByName("MOVIE1");

        Theater inoxTheater = new Theater(1, "INOX", "kukatpally", City.HYDERABAD);
        inoxTheater.setScreen(createScreen());
        Theater pvrTheater = new Theater(2, "PVR", "xyz", City.CHENNAI);
        pvrTheater.setScreen(createScreen());

        theaterController.addTheater(inoxTheater, City.HYDERABAD);
        theaterController.addTheater(pvrTheater, City.CHENNAI);

        createShows(movie2, movie1, inoxTheater, pvrTheater, new Date(2024, 01, 19));
        createShows(movie2, movie1, inoxTheater, pvrTheater, new Date(2024, 01, 18));

    }

    private void createShows(Movie movie2, Movie movie1, Theater inoxTheater, Theater pvrTheater, Date date) {
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(inoxTheater.getScreens().get(0), movie2, 8, date);
        Show inoxEveningShow = createShows(inoxTheater.getScreens().get(0), movie1, 16, date);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheater.setShows(inoxShows);

        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(pvrTheater.getScreens().get(0), movie2, 13, date);
        Show pvrEveningShow = createShows(pvrTheater.getScreens().get(0), movie1, 20, date);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheater.setShows(pvrShows);
    }

    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen = new Screen();
        screen.setScreenId(1);
        screen.setSeats(createSeats());
        screens.add(screen);
        return screens;
    }

    private Show createShows(Screen screen, Movie movie, int showStartTime, Date date) {
        Show show = new Show();
        show.setScreen(screen);
        show.setMovie(movie);
        show.setDate(date);
        show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    //creating 120 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat(SeatCategory.SILVER, 100);
            seat.setSeatId(i);
            seats.add(seat);
        }

        //41 to 70 : GOLD
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat(SeatCategory.GOLD, 200);
            seat.setSeatId(i);
            seats.add(seat);
        }

        //70 to 100 : PLATINUM
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat(SeatCategory.PLATINUM, 300);
            seat.setSeatId(i);
            seats.add(seat);
        }

        //100 to 100 : PLATINUM
        for (int i = 100; i < 120; i++) {
            Seat seat = new Seat(SeatCategory.RECLINER, 400);
            seat.setSeatId(i);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie movie2 = new Movie();
        movie2.setMovieId(1);
        movie2.setMovieName("MOVIE2");
        movie2.setMovieDuration(128);

        //create Movies2
        Movie movie1 = new Movie();
        movie1.setMovieId(2);
        movie1.setMovieName("MOVIE1");
        movie1.setMovieDuration(180);


        //add movies against the cities
        screeningController.addMovie(movie2, City.HYDERABAD);
        screeningController.addMovie(movie2, City.CHENNAI);
        screeningController.addMovie(movie1, City.HYDERABAD);
        screeningController.addMovie(movie1, City.CHENNAI);
    }

    public TheaterController getTheaterController() {
        return theaterController;
    }
}

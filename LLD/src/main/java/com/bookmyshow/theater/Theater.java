package com.bookmyshow.theater;

import com.bookmyshow.City;
import com.bookmyshow.movie.Show;
import com.bookmyshow.screen.Screen;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class Theater {

    int TheaterId;

    String theaterName;
    String address;
    City city;
    List<Screen> screen = new ArrayList<>();
    List<Show> shows = new ArrayList<>();

    public Theater(int TheaterId, String theaterName, String address, City city){
        this.TheaterId = TheaterId;
        this.theaterName = theaterName;
        this.city = city;
        this.address = address;
    }

    public int getTheaterId() {
        return TheaterId;
    }

    public void setTheaterId(int TheaterId) {
        this.TheaterId = TheaterId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getScreens() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows.addAll(shows);
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

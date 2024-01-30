package com.bookmyshow.movie;

import com.bookmyshow.screen.Screen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {
    Movie movie;
    Screen screen;
    int showStartTime;

    Date date;
    List<Integer> bookedSeatIds = new ArrayList<>();

    public Movie getMovie() {
        return movie;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }
}

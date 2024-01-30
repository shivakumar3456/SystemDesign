package com.bookmyshow;

import com.bookmyshow.movie.Show;
import com.bookmyshow.screen.Seat;
import com.bookmyshow.theater.Theater;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
public class BMS {

    private Admin admin;

    BMS() {
        admin = new Admin();
    }

    public static void main(String args[]) {

        BMS bms = new BMS();

        // initialize is used by theater management.
        bms.admin.init();

        // Below steps are related to user who want to book ticket.
        UserPreference userPreference = new UserPreference();
        userPreference.address = "xyz";
        userPreference.date = 19;
        userPreference.city = City.CHENNAI;
        userPreference.showTime = 13;
        userPreference.movieName = "MOVIE2";
        userPreference.screenId = 1;
        userPreference.theaterName = "PVR";
        Optional<Show> optionalShow = bms.getShowBasedOnUserFilter(userPreference);
        if (optionalShow == null) return;
        if (optionalShow.isEmpty()) {
            System.out.println("Interest Show not exist");
            return;
        }
        Show interestedShow = optionalShow.get();


        // in this use case users are not created assume this is from different users.
        //user1
        Booking booking1 = bms.createBooking(interestedShow, 20);
        bms.doPayment(booking1, Payment.PaymentMethod.CASH);
        //user2
        Booking booking2 = bms.createBooking(interestedShow, 20);
        bms.doPayment(booking2, Payment.PaymentMethod.CREDIT_CARD);
    }

    private static class UserPreference{
        City city;
        String theaterName;
        String address;
        int showTime;
        int screenId;
        String movieName;
        int date;
    }

    private Optional<Show> getShowBasedOnUserFilter(UserPreference userPreference) {
        // users gets list of theaters based on city
        List<Theater> theaters = admin.getTheaterController().getTheaters(userPreference.city);
        // selects theater
        Theater interestTheater = theaters.stream().filter(theater -> theater.getTheaterName()
                        .equals(userPreference.theaterName) && theater.getAddress().equals(userPreference.address))
                .findFirst().get();
        if (interestTheater == null) {
            System.out.println("Select theater not found");
            return null;
        }
        // gets interested show
        Optional<Show> optionalShow = interestTheater.getShows().stream()
                .filter(show -> show.getShowStartTime() == userPreference.showTime
                        && show.getScreen().getScreenId() == userPreference.screenId
                        && show.getMovie().getMovieName().equals(userPreference.movieName)
                        && show.getDate().getDate() == userPreference.date)
                .findFirst();
        return optionalShow;
    }

    private void doPayment(Booking booking, Payment.PaymentMethod paymentMethod) {
        if (booking == null) {
            System.out.println("Cannot proceed to payment");
        } else {
            int totalPrice = 0;
            for (Seat seat : booking.getBookedSeats()) {
                int price = seat.getPrice();
                totalPrice += price;
            }
            Payment payment = new Payment(totalPrice, 1, Payment.PaymentStatus.PENDING, paymentMethod);
            System.out.println("Amount to be paid :- " + payment.getAmount());
            // do the payment.
            booking.setPayment(payment);
        }
    }

    private Booking createBooking(Show interestedShow, int seatNumber) {

        List<Integer> bookedSeats = interestedShow.getBookedSeatIds();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            System.out.println("Seat "+ seatNumber + " is available");
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestedShow);
            System.out.println("Proceed to Payment");
            return booking;
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return null;
        }

    }
}

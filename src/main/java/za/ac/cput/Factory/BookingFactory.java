package za.ac.cput.Factory;

import za.ac.cput.Entity.Booking;

/*  BookingFactory.java
 *  Factory for the booking
 *  Author: Ian Louw (216250773)
 *  Date: 11 June 2021
 */

public class BookingFactory {

    public static Booking createBooking(String name, String address, String database, String date, String status, Double price){

        Booking booking = new Booking.Builder().
                                setName(name).
                                setAddress(address).
                                setDatabase(database).
                                setDate(date).
                                setStatus(status).
                                setPrice(price).
                                build();

                                return booking;
    }
}

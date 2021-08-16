package za.ac.cput.Factory;

import za.ac.cput.Entity.Booking;
import za.ac.cput.Util.GenericHelper;

/*  BookingFactory.java
 *  Factory for the booking
 *  Author: Ian Louw(216250773)
 *  Date: 11 June 2021
 */

public class BookingFactory {

    public static Booking createBooking(String name, String address, String database, String date, String status, Double price){

        String bookingID = GenericHelper.generateId();
        Booking booking = new Booking.Builder().setBookingID(bookingID).
                                //setBookingID(bookingID).
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

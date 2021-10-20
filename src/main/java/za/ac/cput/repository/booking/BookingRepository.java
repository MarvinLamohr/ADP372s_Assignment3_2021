/*package za.ac.cput.repository.booking;

import za.ac.cput.entity.Booking;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    private static BookingRepository repository = null;
    private List<Booking> bookingDB;
    private BookingRepository() {
        bookingDB = new ArrayList<Booking>();
    }

    public BookingRepository(List<Booking> bookingDB){
        this.bookingDB = bookingDB;
    }

    public static BookingRepository getRepository(){
        if (repository == null){
            repository = new BookingRepository();
        }
        return repository;
    }


    public Booking create (Booking booking){

        //Booking booking = BookingFactory.createBooking(bookingAddress);
        this.bookingDB.add(booking);
        return booking;
    }

    public Booking read (String bookingID){
        Booking booking = null;
        for (Booking b : bookingDB){
            if (b.getBookingID().equals(bookingID)){
                booking = b;
                break;
            }
        }
        return booking;
    }

    public Booking update (Booking booking){
        Booking oldBooking = read(booking.getBookingID());
        if (oldBooking != null) {
            bookingDB.remove(oldBooking);
            bookingDB.add(booking);
        }
        return booking;
    }

    public boolean delete(String bookingID) {
        Booking bookingToDelete = read(bookingID);
        if (bookingToDelete == null)
            return false;
        bookingDB.remove(bookingToDelete);
        return true;
    }

    public List<Booking> getAll(){
        return bookingDB;
    }
}
*/
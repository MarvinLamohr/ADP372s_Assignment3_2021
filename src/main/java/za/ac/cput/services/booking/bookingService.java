package za.ac.cput.services.booking;

import za.ac.cput.Entity.Booking;
import za.ac.cput.repository.booking.BookingRepository;

import java.util.List;

public class bookingService {

    private static bookingService service;
    private BookingRepository repository;

    private bookingService() {
        this.repository = BookingRepository.getRepository();
    }

    public static bookingService getService() {
        if(service == null) {
            service = new bookingService();
        }
        return service;
    }


    public Booking create (Booking booking) {
        return this.repository.create(booking);
    }

    public Booking read (String bookingID) {
        return this.repository.read(bookingID);
    }

    public Booking update (Booking booking) {
        return this.repository.update(booking);
    }

    public boolean delete (String bookingID) {
        return this.repository.delete(bookingID);
    }

    public List<Booking> getAll() {
        return this.repository.getAll();
    }
}

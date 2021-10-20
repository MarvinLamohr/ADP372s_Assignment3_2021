package za.ac.cput.services.booking;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.services.booking.bookingService;

import static org.junit.jupiter.api.Assertions.*;

class bookingServiceTest {

    private static bookingService bookingService;
    private static Booking booking = BookingFactory.createBooking("0001", "Hendricks", "21 that str", "10 Nov 2021", "Active", 10000.00);

    @Test
    void a_create() {
        Booking created = bookingService.create(booking);
        assertEquals(created.getBookingID(),booking.getBookingID());
        System.out.println("Created: " +created);
    }

    @Test
    void b_read() {
        Booking read = bookingService.read(booking.getBookingID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void c_update() {
        Booking updated = new Booking.Builder().copy(booking).setName("Diedricks").build();
        assertNotNull(bookingService.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        bookingService.delete(booking.getBookingID());
        assertNotNull(bookingService);
        System.out.println("Deleted: " +bookingService.getAll());
    }

    @Test
    void e_getAll() {
        System.out.println("Show all data: ");
        System.out.println(bookingService.getAll());
    }
}
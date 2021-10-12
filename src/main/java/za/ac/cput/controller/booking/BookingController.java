package za.ac.cput.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.entity.Booking;
import za.ac.cput.services.booking.bookingService;

import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private bookingService bookingService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    //@PostMapping("/booking")
    public Booking create(@RequestBody Booking booking) {
        Booking newBooking = BookingFactory.createBooking(booking.getName(), booking.getAddress(), booking.getDatabase(), booking.getDate(), booking.getStatus(), booking.getPrice());
        return bookingService.create(newBooking);
    }

    @GetMapping("/read")
    public Booking read (@RequestBody Booking booking) {
        return bookingService.read(booking.getBookingID());
    }

    @PostMapping("/update")
    public Booking update (@RequestBody Booking booking){
        return bookingService.update(booking);
    }

    @PostMapping("/delete")
    public String delete (@RequestBody Booking booking) {
        if (bookingService.delete(booking.getBookingID()))
            return "deleted successfully";
        else
            return "could not delete";
    }

    @GetMapping("/getall")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }
}

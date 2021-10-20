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

    //@RequestMapping(value = "/create", method = RequestMethod.POST)
    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking) {
        Booking newBooking = BookingFactory.createBooking(  booking.getBookingID(),
                                                            booking.getName(),
                                                            booking.getAddress(),
                                                            //booking.getDatabase(),
                                                            booking.getDate(),
                                                            booking.getStatus(),
                                                            booking.getPrice());
        return bookingService.create(newBooking);
    }

    @GetMapping("/read/{id}")
    public Booking read (@PathVariable String id) {
        return bookingService.read(id);
    }

    @PutMapping ("/update")
    public void update (@RequestBody Booking booking){
        bookingService.update(booking);
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable String id) {
        bookingService.delete(id);
    }

    @GetMapping("/getall")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }
}

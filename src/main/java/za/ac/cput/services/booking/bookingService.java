package za.ac.cput.services.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Booking;
import za.ac.cput.repository.booking.IBookingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class bookingService implements IBookingService{

    @Autowired
    private IBookingRepository repository;

    public Booking create (Booking booking) {
        return this.repository.save(booking);
    }

    public Booking read (String booking) {
        return this.repository.findById(booking).orElseGet(null);
    }

    public Booking update (Booking booking) {
        return this.repository.save(booking);
    }

    public void delete (String booking) {
        this.repository.deleteById(booking);
    }

    public List<Booking> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toList());
    }
}

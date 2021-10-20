package za.ac.cput.repository.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Booking;

public interface IBookingRepository extends JpaRepository<Booking,String> {
}

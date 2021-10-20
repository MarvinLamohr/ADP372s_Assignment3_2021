package za.ac.cput.repository.venue;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue,String> {
}

package za.ac.cput.services.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Venue;
import za.ac.cput.repository.venue.VenueRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueService implements IVenueService{
    private static VenueService venueService = null;

    @Autowired
    private VenueRepository repository;

    @Override
    public Venue create(Venue venue) {
        return this.repository.save(venue);

    }

    @Override
    public Venue read(String venueName) {
        return this.repository.findById(venueName).orElse(null);
    }

    @Override
    public Venue update(Venue venue) {
        if (this.repository.existsById(venue.getVenueName()))
            return this.repository.save(venue);
        return null;
    }

    @Override
    public void delete(String venueName) {
        this.repository.deleteById(venueName);
    }

    @Override
    public List<Venue> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toList());

    }
}

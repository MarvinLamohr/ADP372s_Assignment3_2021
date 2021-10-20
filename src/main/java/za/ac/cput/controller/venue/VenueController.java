package za.ac.cput.controller.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;
import za.ac.cput.services.venue.VenueService;

import java.util.List;

@RestController
@RequestMapping("/venue")
public class VenueController {
    @Autowired
    private VenueService venueService;

    @PostMapping("/create")
    public Venue created(@RequestBody Venue venue){
        Venue newVenue = VenueFactory.createVenue(venue.getVenueName(), venue.getVenueLocation(), venue.getVenueCapacity());
        return  venueService.create(newVenue);
    }

    @GetMapping("/read")
    public  Venue read(@RequestBody Venue venue){
        return venueService.read(venue.getVenueName());
    }
    @PostMapping("/update")
    public  Venue update(@RequestBody Venue venue){
        return venueService.update(venue);
    }

    @DeleteMapping("/delete")
   public void delete(@RequestBody String venueName){
        venueService.delete(venueName);
    }
    @GetMapping("/getall")
    public List<Venue> getAll(){
        return venueService.getAll();
    }

}

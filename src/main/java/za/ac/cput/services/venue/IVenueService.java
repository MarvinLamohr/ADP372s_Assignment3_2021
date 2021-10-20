package za.ac.cput.services.venue;

import za.ac.cput.entity.Venue;
import za.ac.cput.services.IService;

import java.util.List;

public interface IVenueService extends IService<Venue,String> {
    List<Venue> getAll();

}

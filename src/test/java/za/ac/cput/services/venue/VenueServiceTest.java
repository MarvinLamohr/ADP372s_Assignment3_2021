package za.ac.cput.services.venue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class VenueServiceTest {
    @Autowired
    private  VenueService service;
    private  static Venue venue = VenueFactory.createVenue("Sport center","Bellvile",300);

    @Test
    void create() {
        Venue created = service.create(venue);
        assertEquals(created.getVenueName(),venue.getVenueName());
        System.out.println("Created "+ created);
    }

    @Test
    void read() {
        Venue read = service.read(venue.getVenueName());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        Venue updated = new Venue.Builder().copy(venue).setVenueLocation("Wellington").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void delete() {
        service.delete(venue.getVenueName());
        assertNotNull(service);
        System.out.println("Deleted: " +service.getAll());
    }
    @Test
    void d_getAll(){
        System.out.println("Show all data: ");
        System.out.println(service.getAll());
    }


}
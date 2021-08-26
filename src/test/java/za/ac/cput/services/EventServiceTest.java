package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.services.event.EventService;


import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    private static EventService service = EventService.getService();
    private static Event event = EventFactory.createEvent("Lamohr Wedding","Lam2845","50",90,"23 September 2022");

    @Test
    void create() {
        Event created = service.create(event);
        assertEquals(created.getEventID(),event.getEventID());
        System.out.println("Created: " +created);
    }

    @Test
    void read() {
        Event read = service.read(event.getEventID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        Event updated = new Event.Builder().copy(event).setEventName("Robert").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void delete() {
        boolean success = service.delete(event.getEventID());
        assertTrue(success);
        System.out.println("Deleted: " +success);
    }
}
package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Event;
import za.ac.cput.factory.EventFactory;
import za.ac.cput.services.event.EventService;


import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    private static EventService service = EventService.getService();
    private static Event event = EventFactory.createEvent("Lamohr Wedding","Lam2845","2022/09/23");

    @Test
    void a_create() {
        Event created = service.create(event);
        assertEquals(created.getEventID(),event.getEventID());
        System.out.println("Created: " +created);
    }

    @Test
    void b_read() {
        Event read = service.read(event.getEventID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void c_update() {
        Event updated = new Event.Builder().copy(event).setEventName("Robert").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(event.getEventID());
        assertTrue(success);
        System.out.println("Deleted: " +success);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all data: ");
        System.out.println(service.getAll());
    }
}
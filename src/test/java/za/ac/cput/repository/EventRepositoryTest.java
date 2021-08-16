package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.repository.event.impl.EventRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EventRepositoryTest {

    private static EventRepository repository = EventRepository.getRepository();

    private static Event event = EventFactory.createEvent( "SA Music Awards","SAMusic 2022","500",1000,"16 June 2022");

    @Test
    void create() {
        Event created = repository.create(event);
        assertEquals(created.getEventID(),event.getEventID());
        System.out.println("Create: "+ created);
    }

    @Test
    void read() {
        Event read = repository.read(event.getEventID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void update() {
        Event updated = new Event.Builder().copy(event).setEventName("Romano Wedding").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void delete() {
        Event deleted = repository.delete(event.getEventID());
        assertNotNull(deleted);
        System.out.println("Delete: "+ deleted);
    }
}
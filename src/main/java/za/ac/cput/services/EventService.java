package za.ac.cput.services;

import za.ac.cput.Entity.Event;
import za.ac.cput.repository.event.impl.EventRepository;
import za.ac.cput.services.event.IEventService;

public class EventService implements IEventService {

private static EventService service;
private EventRepository repository;

    private EventService() {
        this.repository = EventRepository.getRepository();
    }

    public static EventService getService(){
        if(service == null) {
            service = new EventService();
        }
        return service;
    }

    @Override
    public Event create(Event event) {
        return this.repository.create(event);
    }
    @Override
    public Event read(String eventId) {
        return this.repository.read(eventId);
    }

    @Override
    public Event update(Event event) {
        return this.repository.update(event);
    }
    @Override
    public boolean delete(String eventId) {
        this.repository.delete(eventId);
        return false;
    }
}

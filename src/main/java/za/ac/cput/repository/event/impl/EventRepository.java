package za.ac.cput.repository.event.impl;

import za.ac.cput.Entity.Event;
import za.ac.cput.repository.event.IEventRepository;

import java.util.ArrayList;
import java.util.List;

public class EventRepository implements IEventRepository {

    private static EventRepository repository = null;
    private List<Event> eventDB = null;
    private EventRepository(){
        eventDB = new ArrayList<Event>();
    }

    public static EventRepository getRepository(){
        if(repository == null){
            repository=new EventRepository();
        }
        return repository;
    }
    @Override
    public Event create(Event event) {
        this.eventDB.add(event);
        return event;
    }

    @Override
    public Event read(String eventId) {
        for(Event evt : eventDB)
            if(evt.getEventID().equals(eventId)){
                return evt;
            }
        return null;
    }

    @Override
    public Event update(Event event) {
        Event oldEvent = read(event.getEventID());
        if(oldEvent != null){
            eventDB.remove(oldEvent);
            eventDB.add(event);
            return event;
        }
        return null;
    }

    @Override
    public boolean delete(String eventId) {
        Event eventToDelete = read(eventId);
        if(eventToDelete == null)
            return false;
        eventDB.remove(eventToDelete);
        return true;
    }
}

package za.ac.cput.services.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Event;
import za.ac.cput.repository.event.EventRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService implements IEventService {

@Autowired
private EventRepository eventRepository;

    @Override
    public Event create(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Event read(String event) {
        return this.eventRepository.findById(event).orElseGet(null);
    }

    @Override
    public Event update(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public boolean delete(String event) { this.eventRepository.deleteById(event);;
        return false;
    }

    public List<Event> getAll() { return this.eventRepository.findAll().stream().collect(Collectors.toList());
    }
}

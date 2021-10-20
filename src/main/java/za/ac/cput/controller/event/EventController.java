package za.ac.cput.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Event;
import za.ac.cput.factory.EventFactory;
import za.ac.cput.services.event.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public Event create (@RequestBody Event event){
        Event newEvent = EventFactory.createEvent(event.getEventName(),
                                                  event.getEventID(),
                                                  event.getDate());
        return eventService.create(newEvent);
    }

    @GetMapping("/read/{id}")
    public Event read(@PathVariable String id){
        return eventService.read(id);
    }

    @PutMapping("/update")
    public Event update(@RequestBody Event event){
        return eventService.update(event);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){ eventService.delete(id);
    }
    @GetMapping("/getall")
    public List<Event> getAll(){ return eventService.getAll(); }
}

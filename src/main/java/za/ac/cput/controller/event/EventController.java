package za.ac.cput.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Event;
import za.ac.cput.factory.EventFactory;
import za.ac.cput.services.event.EventService;

import java.util.List;

@RestController
@RequestMapping()
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

    @GetMapping("/read")
    public Event read(@PathVariable String id){
        return eventService.read(id);
    }

    @PostMapping("/update")
    public Event update(@RequestBody Event event){
        return eventService.update(event);
    }

    @DeleteMapping
    public String delete(@PathVariable String id){
        if(eventService.delete(id))
            return "Event Successfully Deleted";

        else
            return "Event Could Not Be Deleted";

    }
    @GetMapping("/getall")
    public List<Event> getAll(){return eventService.getAll(); }
}

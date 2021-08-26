package za.ac.cput.controller.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Event;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.services.event.EventService;

@RestController
@RequestMapping()
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Event create (Event event){
        Event newEvent = EventFactory.createEvent(event.getEventName(),
                                                  event.getEventID(),
                                                  event.getDate(),
                                                  event.getCapacity(),
                                                  event.getGuestList());
        return eventService.create(newEvent);
    }

    @GetMapping("/read")
    public Event read(@RequestBody Event event){
        return eventService.read(event.getEventID());
    }

    @PostMapping("/update")
    public Event update(@RequestBody Event event){
        return eventService.update(event);
    }

    @PostMapping
    public String delete(@RequestBody Event event){
        if(eventService.delete(event.getEventID()))
            return "Event Successfully Deleted";

        else
            return "Event Could Not Be Deleted";

    }
}

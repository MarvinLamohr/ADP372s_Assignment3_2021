package za.ac.cput.controller.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Guest;

import za.ac.cput.factory.GuestFactory;
import za.ac.cput.services.guest.GuestService;

@RestController
@RequestMapping
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Guest create (Guest guest){
        Guest newGuest = GuestFactory.createGuest(guest.getGuestAmount());
        return guestService.create(newGuest);
    }

    @GetMapping("/read")
    public Guest read(@RequestBody Guest guest){
        return guestService.read(guest.getGuestAmount());
    }

    @PostMapping("/update")
    public Guest update(@RequestBody Guest guest){
        return guestService.update(guest);
    }

    @PostMapping
    public void delete(@RequestBody Guest guest){
        guestService.delete(guest.getGuestAmount());

    }
}

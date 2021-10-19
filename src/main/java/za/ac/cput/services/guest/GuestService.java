package za.ac.cput.services.guest;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Guest;
import za.ac.cput.repository.guest.impl.GuestRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GuestService implements IGuestService {

    private static GuestService service;

    @Autowired
    private GuestRepository repository;



    public static GuestService getService(){
        if(service == null) {
            service = new GuestService();
        }
        return service;
    }

    @Override
    public Guest create(Guest amount) {
        return this.repository.save(amount);
    }
    @Override
    public Guest read(Integer guestAmount) {
        return this.repository.findById(guestAmount).orElse(null);
    }

    @Override
    public Guest update(Guest guest) {
        if(this.repository.existsById(guest.getGuestAmount()))
            return this.repository.save(guest);
        return null;
    }
    @Override
    public boolean delete(Integer amount) {
        this.repository.deleteById(amount);
        if(this.repository.existsById(amount))
            return false;
        else
            return true;
    }

   // @Override
    public List<Guest> getAll(){return this.repository.findAll().stream().collect(Collectors.toList());}

}

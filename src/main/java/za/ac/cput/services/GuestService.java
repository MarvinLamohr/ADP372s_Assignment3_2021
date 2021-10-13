package za.ac.cput.services;

import za.ac.cput.Entity.Guest;
import za.ac.cput.repository.guest.impl.GuestRepository;
import za.ac.cput.services.guest.IGuestService;

public class GuestService implements IGuestService {

    private static GuestService service;
    private GuestRepository repository;

    private GuestService() {
        this.repository = GuestRepository.getRepository();
    }

    public static GuestService getService(){
        if(service == null) {
            service = new GuestService();
        }
        return service;
    }

    @Override
    public Guest create(Guest amount) {
        return this.repository.create(amount);
    }
    @Override
    public Guest read(Integer guestAmount) {
        return this.repository.read(guestAmount);
    }

    @Override
    public Guest update(Guest guest) {
        return this.repository.update(guest);
    }
    @Override
    public boolean delete(Integer amount) {
        this.repository.delete(amount);
        return false;
    }
}

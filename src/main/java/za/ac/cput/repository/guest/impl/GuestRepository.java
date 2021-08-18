package za.ac.cput.repository.guest.impl;



import za.ac.cput.Entity.Guest;
import za.ac.cput.repository.guest.IGuestRepository;

import java.util.ArrayList;
import java.util.List;

public class GuestRepository implements IGuestRepository {

    private static GuestRepository repository = null;
    private List<Guest> guestDB = null;
    private GuestRepository(){
        guestDB = new ArrayList<Guest>();
    }

    public static GuestRepository getRepository(){
        if(repository == null){
            repository=new GuestRepository();
        }
        return repository;
    }

    @Override
    public Guest create(Guest guest) {
        this.guestDB.add(guest);
        return guest;
    }

    @Override
    public Guest read(Integer guestAmount) {
        for(Guest gest: guestDB)
            if(gest.getGuestAmount() == guestAmount){
                return gest;
            }
        return null;
    }

    @Override
    public Guest update(Guest guest) {
        Guest oldGuest = read(guest.getGuestAmount());
        if(oldGuest != null){
            guestDB.remove(oldGuest);
            guestDB.add(guest);
            return guest;
        }
        return null;
    }

    @Override
    public Guest delete(Integer guestAmount) {
        Guest guestToDelete = read(guestAmount);
        if(guestToDelete == null)
            return null;
        guestDB.remove(guestToDelete);
        return null;
    }
}

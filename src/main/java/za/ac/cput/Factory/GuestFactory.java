package za.ac.cput.Factory;

import za.ac.cput.Entity.Guest;

public class GuestFactory {
    public static Guest createGuest(int guestAmount){

        Guest guest = new Guest.Builder()
                        .setGuestAmount(guestAmount)
                        .build();

        return guest;}
}

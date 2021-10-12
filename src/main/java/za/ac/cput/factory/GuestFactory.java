package za.ac.cput.factory;
/**
 * GuestFactory.java
 *
 *
 * Mogamat Yaseen Levy - 218003323
 */
import za.ac.cput.entity.Guest;

public class GuestFactory {
    public static Guest createGuest(int guestAmount){

        Guest guest = new Guest.Builder()
                        .setGuestAmount(guestAmount)
                        .build();

        return guest;}
}

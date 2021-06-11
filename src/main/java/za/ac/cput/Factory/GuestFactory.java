package za.ac.cput.Factory;
/**
 * GuestFactory.java
 *
 *
 * Mogamat Yaseen Levy - 218003323
 */
import za.ac.cput.Entity.Guest;

public class GuestFactory {
    public static Guest createGuest(int guestAmount){

        Guest guest = new Guest.Builder()
                        .setGuestAmount(guestAmount)
                        .build();

        return guest;}
}

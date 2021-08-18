package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Guest;
import za.ac.cput.Factory.GuestFactory;

import static org.junit.jupiter.api.Assertions.*;

class GuestServiceTest {

    private static GuestService service = GuestService.getService();
    private static Guest guest = GuestFactory.createGuest(40);

    @Test
    void create() {
        Guest created = service.create(guest);
        assertEquals(created.getGuestAmount(),guest.getGuestAmount());
        System.out.println("Created: " +created);
    }

    @Test
    void read() {
        Guest read = service.read(guest.getGuestAmount());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        Guest updated = new Guest.Builder().copy(guest).setGuestAmount(40).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void delete() {
        boolean success = service.delete(guest.getGuestAmount());
        assertTrue(success);
        System.out.println("Deleted: " +success);
    }
}
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Guest;
import za.ac.cput.Factory.GuestFactory;
import za.ac.cput.repository.guest.impl.GuestRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class GuestRepositoryTest {

    private static GuestRepository repository = GuestRepository.getRepository();

    private static Guest guest = GuestFactory.createGuest(20);


    @Test
    void create() {
        Guest created = repository.create(guest);
        assertEquals(created.getGuestAmount(),guest.getGuestAmount());
        System.out.println("Create: "+ created);
    }

    @Test
    void read() {
        Guest read = repository.read(guest.getGuestAmount());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void update() {
        Guest updated = new Guest.Builder().copy(guest).setGuestAmount(20).build();
        updated = repository.update(updated);
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }


    @Test
    void delete() {
        Guest deleted = repository.delete(guest.getGuestAmount());
        assertNotNull(deleted);
        System.out.println("Delete: "+ deleted);
    }
}
package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Payment;
import za.ac.cput.entity.WeddingsSA;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.factory.WeddingsSAFactory;
import za.ac.cput.services.weddingsSA.WeddingsSAService;

import static org.junit.jupiter.api.Assertions.*;

public class WeddingsSAServiceTest {

    private static WeddingsSAService WeddingsSAService;
    private static WeddingsSA weddingsSA = WeddingsSAFactory.createWeddingsSA("Weddings SA", 763456789);


    @Test
    void create() {
        WeddingsSA created = WeddingsSAService.create(weddingsSA);
        assertEquals(created.getCompanyName(),weddingsSA.getCompanyName());
        System.out.println("Created: " +created);
    }

    @Test
    void read() {
        WeddingsSA read = WeddingsSAService.read(weddingsSA.getCompanyName());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        WeddingsSA updated = new WeddingsSA.Builder().copy(weddingsSA).setCompanyName("Another").build();
        assertNotNull(WeddingsSAService.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void delete() {
        WeddingsSAService.delete(weddingsSA.getCompanyName());
        assertNotNull(WeddingsSAService);
        System.out.println("Deleted: " +WeddingsSAService.getAll());
    }
}


package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Payment;
import za.ac.cput.entity.WeddingsSA;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.factory.WeddingsSAFactory;
import za.ac.cput.services.weddingsSA.WeddingsSAService;

import static org.junit.jupiter.api.Assertions.*;

public class WeddingsSAServiceTest {

    private static WeddingsSAService service = WeddingsSAService.getService();
    private static WeddingsSA weddingsSA = WeddingsSAFactory.createWeddingsSA("Weddings SA", 763456789);


    @Test
    void create() {
        WeddingsSA created = service.create(weddingsSA);
        assertEquals(created.getCompanyName(),weddingsSA.getCompanyName());
        System.out.println("Created: " +created);
    }

    @Test
    void read() {
        WeddingsSA read = service.read(weddingsSA.getCompanyName());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        WeddingsSA updated = new WeddingsSA.Builder().copy(weddingsSA).setCompanyName("Another").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void delete() {
        boolean success = service.delete(weddingsSA.getCompanyName());
        assertTrue(success);
        System.out.println("Deleted: " +success);
    }
}


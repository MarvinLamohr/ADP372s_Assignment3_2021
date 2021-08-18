package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private static PaymentService service = PaymentService.getService();
    private static Payment payment = PaymentFactory.createPayment(4000);


    @Test
    void create() {
        Payment created = service.create(payment);
        assertEquals(created.getAmount(),payment.getAmount());
        System.out.println("Created: " +created);
    }

    @Test
    void read() {
        Payment read = service.read(payment.getAmount());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        Payment updated = new Payment.Builder().copy(payment).setAmount(4000).build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void delete() {
        boolean success = service.delete(payment.getAmount());
        assertTrue(success);
        System.out.println("Deleted: " +success);
    }
}
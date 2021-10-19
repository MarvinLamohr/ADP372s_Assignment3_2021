package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.repository.payment.impl.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentRepositoryTest {

   /* private static PaymentRepository repository ;

    private static Payment payment = PaymentFactory.createPayment(4000);


    @Test
    void create() {
        Payment created = repository.findById(payment);
        assertEquals(created.getAmount(),payment.getAmount());
        System.out.println("Create: "+ created);
    }

    @Test
    void read() {

        Payment read = repository.read(payment.getAmount());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void update() {
        Payment updated = new Payment.Builder().copy(payment).setAmount(20).build();
        updated = repository.update(updated);
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void delete() {
        Payment deleted = repository.delete(payment.getAmount());
        assertNotNull(deleted);
        System.out.println("Delete: "+ deleted);
    }*/
}
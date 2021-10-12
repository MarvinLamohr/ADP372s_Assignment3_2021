package za.ac.cput.factory;
/**
 * PaymentFactoryTest.java
 * Test of Factory for Payment
 *
 * Mogamat Yaseen Levy - 218003323
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Payment;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    private Payment amount;
    private Payment payment;

    @BeforeEach
    void setUp() {

        amount = new Payment.Builder().setAmount(200).build();
        payment = amount;



    }

    @Test
    void testEquality() {

        assertEquals(amount, payment);
        System.out.println("Test equality passed, amounts are equal");
    }

    @Test
    void testIdentity() {

        assertSame(payment,amount);
        System.out.println("Test Identity passed, payment & amount identical");

    }

    @Test
    @Timeout(6)
    void testTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

    }

    @Test
    @Disabled
    void testDisable(){

        assertEquals(amount, payment);
    }
}
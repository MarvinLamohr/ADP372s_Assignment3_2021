package za.ac.cput.Factory;
/**
 * GuestFactoryTest.java
 * Test of Factory for Guest
 *
 * Mogamat Yaseen Levy - 218003323
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Guest;


import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class GuestFactoryTest {

    private Guest amount;
    private Guest amountGuest;


    @BeforeEach
    void setUp() {

        amount = new Guest.Builder().setGuestAmount(2).build();
        amountGuest = amount;



    }

    @Test
    void testEquality() {

        assertEquals(amount, amountGuest);
        System.out.println("Test equality passed, equal");
    }

    @Test
    void testIdentity() {

        assertSame(amountGuest,amount);
        System.out.println("Test Identity passed");

    }

    @Test
    @Timeout(6)
    void testTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

    }

    @Test
    @Disabled
    void testDisable(){

        assertEquals(amount, amountGuest);
    }




}
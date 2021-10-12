package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import za.ac.cput.entity.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

/*  BookingFactoryTest.java
 *  Test case for BookingFactory
 *  Author: Ian Louw (216250773)
 *  Date: 11 June 2021
 */

class BookingFactoryTest {

    private Booking booking1;
    private Booking booking2;

    @BeforeEach
    void setUp() {

        Booking booking1 = new Booking.Builder().setName("Hendricks").build();
        Booking booking2 = booking1;

    }
    @Test
    void testEquality(){

        assertEquals(booking2, booking1);
        System.out.println("This is equal");
    }

    @Test
    void testIdentity() {

        assertSame(booking2, booking1);
        System.out.println("This is identical");
    }

    @Test
    void testTimeout() {

        assertTimeout(Duration.ofMinutes(100), () -> {
            Thread.sleep(2000);

            System.out.println("Test Timed out");
        });
    }

    @Test
    @Disabled
    void testDisable() {

        assertEquals(booking2, booking1);
    }
}
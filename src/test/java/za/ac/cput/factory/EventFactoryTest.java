
/* EventFactoryTest.java
   Test for the EventFactory
   Author: Marvin Lamohr (214273830)
   Date: 11 June 2021
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {

    private Event event1;
    private Event event2;

    @BeforeEach
    void setUp(){
        Event event1 = new Event.Builder().setEventID("").
                setEventName("").
                setDate("").
                setCapacity(50).
                setGuestList("").
                build();
        Event event2 = event1;
    }

    @Test
    void testEquality(){
        assertEquals(event1,event2);
        System.out.println("It is... Equal!");
    }

    @Test
    void testIdentity(){
        assertSame(event2,event1);
        System.out.println("It is... Identical!");
    }

    @Test
    @Timeout(2)
    void testTimeout() throws InterruptedException {
        Thread.sleep(200);
        System.out.println("Test timed out.... Please be patient test will pass soon...!");
    }

    @Test
    @Disabled
    void testDisable(){
        assertEquals(event2,event1);
    }
}
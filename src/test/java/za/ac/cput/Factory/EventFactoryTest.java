package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {

    private Event event1;
    private Event event2;

    @BeforeEach
    void setUp(){

        Event event1 = new Event.Builder().
                           setEventName("Lamohr Wedding").
                           setEventID("e32v26w1").
                           setDate("24 September 2021").
                           setCapacity(350).
                           setGuestList("250").
                           build();

        Event event2 = event1;

    }

    @Test
    void objectEquality(){

        assertEquals(event2,event1);

    }

    @Test
    void objectIdentity(){

        assertSame(event1,event2);

    }

    @Test
    @Timeout(3)
    void timeOuts() throws InterruptedException{

        Thread.sleep(300);
        System.out.println("Loadshedding Will Be Over Soon... Please be patient...");

    }

    @Test
    @Disabled
    void disablingTest() throws InterruptedException{

        assertEquals(event1,event2);
        System.out.println("Just Married, Bye Bye");

    }
}
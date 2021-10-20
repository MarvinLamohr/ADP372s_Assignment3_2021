package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Venue;

import static org.junit.jupiter.api.Assertions.*;

class VenueFactoryTest {
    private Venue venue1,venue2,venue3;

    @BeforeEach
    void setUp() {
        venue1 = new Venue.Builder().setVenueName("Eyadini").setVenueCapacity(20).setVenueLocation("Durban").build();
        venue2 = new Venue.Builder().setVenueName("Waterfront").setVenueCapacity(15).setVenueLocation("Cape Town").build();
        venue3= venue2;
    }

    //Testing for Equality
    @Test
    void testObjectEquality(){
        assertEquals(venue3,venue2);

    }

    //Testing for Identity
    @Test
    void testObjectIdentity(){
        assertSame(venue1,venue2);
    }

    //Timeout Test
    @Test
    @Timeout(9)
    void timeOut()throws InterruptedException{
        Thread.sleep(9000);
    }

    //Disabling test
    @Disabled
    @Test
    void disabled(){
        assertEquals(venue2,venue3);
    }

}
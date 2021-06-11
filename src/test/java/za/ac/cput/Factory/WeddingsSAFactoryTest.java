package za.ac.cput.Factory;

/**
 * WeddingsSAFactoryTest.java
 * Test of Factory for WeddingsSA
 *
 * Lefu Kumeke - 218147856
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.WeddingsSA;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


class WeddingsSAFactoryTest {

      private WeddingsSA weddingsSA;
      private WeddingsSA anotherCompany;



    @BeforeEach
    void setUp() {

        weddingsSA = new WeddingsSA.Builder().setCompanyName("Weddings SA").setContact(763456789).build();
        anotherCompany = weddingsSA;


        
    }

    @Test
    void testEquality() {

        assertEquals(anotherCompany, weddingsSA);
        System.out.println("Equal");
    }

    @Test
    void testIdentity() {

        assertSame(anotherCompany, weddingsSA);
        System.out.println("Identical");

    }

    @Test
    @Timeout(6)
    void testTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

    }
    @Test
    @Disabled
    void testDisable(){

        assertEquals(anotherCompany, weddingsSA);
    }


}
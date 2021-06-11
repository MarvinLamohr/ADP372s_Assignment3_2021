/* AddressFactoryTest
    Test for AddressFactory
    Author: Mawande Langa (219074054)
    Date: 11/06/2021

 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Address;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    private Address address1,address2,address3;

    @BeforeEach
    void setUp() {
       address1 = new Address.Builder().setStreetAddress("Molokwane St").setPostalAddress("X63").build();
       address2 = new Address.Builder().setStreetAddress("Adderly St").setPostalAddress("Cape Town").build();
       address3 = address1;
    }


    //Testing for Equality
    @Test
    void testObjectEquality(){
        assertEquals(address3,address1);

    }

    //Testing for Identity
    @Test
    void testObjectIdentity(){
        assertSame(address1,address3);

    }

    //Timeout Test
    @Test
    @Timeout(10)
    void timeOut()throws InterruptedException{
        Thread.sleep(10000);
    }


    //Disabling test
    @Disabled
    @Test
    void disabled(){
        assertEquals(address1,address2);
    }

}
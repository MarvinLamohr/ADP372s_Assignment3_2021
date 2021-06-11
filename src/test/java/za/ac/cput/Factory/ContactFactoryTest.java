/* ContactFactoryTest.java
   FactoryTest for the ContactFactoryTest
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */
package za.ac.cput.Factory;

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

        Contact contact1 = ContactFactory.createContact("950998","08184255", "2175412", "event@gmail.com");
        Contact contact2 = contact1;

    @Test
    void testIdentity()
    {
        assertSame(contact1,contact2);
    }
    @Test
    void testEquality()
    {
        assertEquals(contact1,contact1);
    }
    @Test
    @Disabled
    @DisplayName("This method should not run")
    void testDisabled()
    {
       fail("this test method should be disabled");

    }
    @Test
    @Timeout(5)
    public void timeoutTest() throws InterruptedException{
        Thread.sleep(500);
        System.out.println("Test will passed with in the time");
    }
}

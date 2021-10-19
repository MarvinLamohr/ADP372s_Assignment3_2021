/* ContactFactoryTest.java
   FactoryTest for the ContactFactoryTest
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    @Test
    void  createContact(){
        Contact contact = ContactFactory.createContact("217022","2154","savie@gmail.com");
        System.out.println(contact);
    }
}

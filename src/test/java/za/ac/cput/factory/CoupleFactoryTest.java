package za.ac.cput.factory;

import org.junit.jupiter.api.*;
/* CoupleFactoryTest.java
   FactoryTest for the CoupleFactoryTest
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */

import za.ac.cput.entity.Contact;
import za.ac.cput.entity.Couple;

import static org.junit.jupiter.api.Assertions.*;

class CoupleFactoryTest {

    @Test
    void  createContact(){
        Couple couple = CoupleFactory.createCouple("madladla","Cape Town","female","24");
        System.out.println(couple);
    }
}
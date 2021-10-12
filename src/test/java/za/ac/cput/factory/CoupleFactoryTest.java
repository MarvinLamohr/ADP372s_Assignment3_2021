package za.ac.cput.factory;

import org.junit.jupiter.api.*;
/* CoupleFactoryTest.java
   FactoryTest for the CoupleFactoryTest
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */

import za.ac.cput.entity.Couple;

import static org.junit.jupiter.api.Assertions.*;

class CoupleFactoryTest {

        Couple couple = CoupleFactory.createCouple("Sam", "Cape Town", "female", 28);
        Couple couple1 = couple;


    @Test
        void testIdentity()
        {
            assertSame(couple1,couple1);
        }
        @Test
        void testEquality()
        {
            assertEquals(couple,couple);
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

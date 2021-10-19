
/* EmployeeFactoryTest.java
   Test for the EmployeeFactory
   Author: Marvin Lamohr (214273830)
   Date: 11 June 2021
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    void setUp(){
        Employee employee1 = new Employee.Builder().
                setEmployeeFirstName("").
                setEmployeeLastName("").
                setEmployeeID("").
                setEmployeeContactNumber("").
                setEmployeeAddress("").
                setEmployeeEmail("").
                setPosition("").
                build();
        Employee employee2 = employee1;
    }

    @Test
    void testEquality(){
        assertEquals(employee1,employee2);
        System.out.println("It is... Equal!");
    }

    @Test
    void testIdentity(){
        assertSame(employee2,employee1);
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
       assertEquals(employee2,employee1);
    }
}
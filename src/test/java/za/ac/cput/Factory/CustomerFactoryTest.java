package za.ac.cput.Factory;

/**
 * CustomerFactory.java
 * Factory Test for the Customer
 *
 * Lefu Kumeke - 218147856
 *
 */

import org.junit.jupiter.api.*;
import za.ac.cput.Entity.Customer;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private  Customer customer1;
    private  Customer customer2;




    @BeforeEach
    void setUp() {
         customer1 = CustomerFactory.createCustomer("John", "111" , "8 Browning rd , Salt River" , 25 , 999999999);
        customer2 =  customer1;

    }

    @Test
    void testEquality() {


        assertEquals(customer2, customer1);
        System.out.println("Equal");

    }
    @Test
    void testIdentity() {

        assertSame(customer2, customer1);
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

        assertEquals(customer2, customer1);
    }

}
package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Customer;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Guest;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.services.customer.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {


    private static CustomerService service = CustomerService.getService();
    private static Customer customer = CustomerFactory.createCustomer("John", "111" , "8 Browning rd , Salt River" , 25 , 999999999);

    @Test
    void create() {
        Customer created = service.create(customer);
        assertEquals(created.getCustomerID(),customer.getCustomerID());
        System.out.println("Created: " +created);
    }

    @Test
    void read() {
        Customer read = service.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        Customer updated = new Customer.Builder().copy(customer).setCustomerName("Lefu").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);

    }
        @Test
        void delete() {
            boolean success = service.delete(customer.getCustomerID());
            assertTrue(success);
            System.out.println("Deleted: " + success);

        }}

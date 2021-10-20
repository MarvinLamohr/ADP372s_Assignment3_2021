package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Customer;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.Guest;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.services.customer.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerServiceTest {


    private static CustomerService CustomerService;
    private static Customer customer = CustomerFactory.createCustomer("John", "111" , "8 Browning rd , Salt River" , 25 , 999999999);

    @Test
    void create() {
        Customer created = CustomerService.create(customer);
        assertEquals(created.getCustomerID(),customer.getCustomerID());
        System.out.println("Created: " +created);
    }

    @Test
    void read() {
        Customer read = CustomerService.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void update() {
        Customer updated = new Customer.Builder().copy(customer).setCustomerName("Lefu").build();
        assertNotNull(CustomerService.update(updated));
        System.out.println("Updated: " + updated);

    }
        @Test
        void delete() {
            CustomerService.delete(customer.getCustomerID());
            assertNotNull(CustomerService);
            System.out.println("Deleted: " + CustomerService);

        }}

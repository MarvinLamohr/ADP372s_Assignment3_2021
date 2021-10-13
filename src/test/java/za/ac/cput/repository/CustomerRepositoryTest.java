package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.Employee;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.repository.customer.impl.CustomerRepository;
import za.ac.cput.repository.event.impl.EventRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static za.ac.cput.Factory.CustomerFactory.createCustomer;

public class CustomerRepositoryTest {


    private static CustomerRepository repository = CustomerRepository.getRepository();

    private static Customer customer = CustomerFactory.createCustomer("John", "111" , "8 Browning rd , Salt River" , 25 , 999999999);


    @Test
    void create() {
        Customer created = repository.create(customer);
        assertEquals(created.getCustomerID(),customer.getCustomerID());
        System.out.println("Create: "+ created);
    }

    @Test
    void read() {
        Customer read = repository.read(customer.getCustomerID());
       assertNotNull(read);
        //assertEquals(read.getCustomerID(),customer.getCustomerID());
        System.out.println("Read: "+ read);
    }

    @Test
    void update() {
        Customer updated = new Customer.Builder().copy(customer).setCustomerName("Blue").setcustomerID("777").setAddress("98 summer rd").setAge(17).setContact(7777).build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void delete() {
        Customer deleted = repository.delete(customer.getCustomerID());
        assertNotNull(deleted);
        System.out.println("Delete: "+ deleted);
    }
}



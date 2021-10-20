package za.ac.cput.services.address;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class AddressServiceTest {
    @Autowired
    private  AddressService service;

    private static Address address = AddressFactory.createAddress("X63 Molokwane", "8000");

    @Test
    void a_create() {
        Address created = service.create(address);
        assertEquals(created.getStreetAddress(),address.getStreetAddress());
        System.out.println("create" + created);
    }

    @Test
    void b_read() {
        Address read = service.read(address.getStreetAddress());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Address old = service.read(" X63 Molokwane");
        Address updated = new Address.Builder().copy(old).setPostalAddress("7806").build();
        System.out.println("updated" + updated);
    }

    @Test
    void d_delete() {
        service.delete(address.getStreetAddress());
        assertNotNull(service);
        System.out.println("Delete" + service);
    }

    @Test
    void e_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }

}
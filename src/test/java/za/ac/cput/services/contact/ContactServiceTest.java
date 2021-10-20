package za.ac.cput.services.contact;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Contact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.services.contact.ContactService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ContactServiceTest {
    @Autowired
    private  ContactService service;

    private  static Contact contact = ContactFactory.createContact("08377","02155","@gmail");



    @Test
    void a_create() {
        Contact created = service.create(contact);
        assertEquals(created.getId(),contact.getId());
        System.out.println("create" + created);
    }

    @Test
    void b_read() {
        Contact read = service.read(contact.getId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Contact old = service.read("7bab3ea9-5dbe-4de9-a5d6-ca20897bfd");
        Contact updated = new Contact.Builder().copy(old).setEmail("madladla@gmail.com").build();
        System.out.println("updated" + updated);
    }

    @Test
    void e_delete() {
        service.delete("7bab3ea9-5dbe-4de9-a5d6-ca20897bfd");
        assertNotNull(service);
        System.out.println("Delete" + service);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}
package za.ac.cput.services.couple;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Contact;
import za.ac.cput.entity.Couple;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CoupleFactory;
import za.ac.cput.services.contact.ContactService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CoupleServiceTest {
    @Autowired
    private CoupleService service;

    private  static Couple couple = CoupleFactory.createCouple("Smith","Belhar","male", "30");


    @Test
    void a_create() {
        Couple created = service.create(couple);
        assertEquals(created.getCoupleId(),couple.getCoupleId());
        System.out.println("create" + created);
    }

    @Test
    void b_read() {
        Couple read = service.read(couple.getCoupleId());
        assertNotNull(read);
        System.out.println("Read" + read);
    }

    @Test
    void c_update() {
        Couple old = service.read("7bab3ea9-5dbe-4de9-a5d6-ca20897bfd");
        Couple updated = new Couple.Builder().copy(old).setCoupleSurname("Sam").build();
        System.out.println("updated" + updated);
    }

    @Test
    void e_delete() {
        service.delete(couple.getCoupleId());
        assertNotNull(service);
        System.out.println("Deleted: " +service.getAll());
    }

    @Test
    void d_getAll() {
            System.out.println("Show All:");
            System.out.println(service.getAll());
    }
}
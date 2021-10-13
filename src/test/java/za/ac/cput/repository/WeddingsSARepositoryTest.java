package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.WeddingsSA;
import za.ac.cput.Factory.WeddingsSAFactory;
import za.ac.cput.repository.weddingsSA.impl.WeddingsSARepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WeddingsSARepositoryTest {

    private static WeddingsSARepository repository = WeddingsSARepository.getRepository();

    private static WeddingsSA weddingsSA = WeddingsSAFactory.createWeddingsSA("Weddings SA", 763456789);



    @Test
    void create() {
        WeddingsSA created = repository.create(weddingsSA);
        assertEquals(created.getCompanyName(),weddingsSA.getCompanyName());
        System.out.println("Create: "+ created);
    }

    @Test
    void read() {
        WeddingsSA read = repository.read(weddingsSA.getCompanyName());
        assertNotNull(read);

        System.out.println("Read: "+ read);
    }

    @Test
    void update() {
        WeddingsSA updated = new WeddingsSA.Builder().copy(weddingsSA).setCompanyName("Weddings SA").setContact( 763456789).build();
               // assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void delete() {
        WeddingsSA deleted = repository.delete(weddingsSA.getCompanyName());
        assertNotNull(deleted);
        System.out.println("Delete: "+ deleted);
    }
}


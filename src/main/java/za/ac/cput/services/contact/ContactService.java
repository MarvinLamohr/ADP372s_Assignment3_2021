package za.ac.cput.services.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Contact;
import za.ac.cput.entity.Couple;
import za.ac.cput.repository.contact.ContactRepository;

import java.util.Set;
import java.util.stream.Collectors;
@Service
public class ContactService implements IContactService {
    private static  ContactService service = null;

    @Autowired
    private ContactRepository repository = null;


    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String contactId) {
        return this.repository.findById(contactId).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        if (this.repository.existsById(contact.getId()))
            return this.repository.save(contact);
        return null;
    }
    @Override
    public boolean delete(String coupleId) {
        this.repository.deleteById(coupleId);
        return false;
    }

    public Set<Contact> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}


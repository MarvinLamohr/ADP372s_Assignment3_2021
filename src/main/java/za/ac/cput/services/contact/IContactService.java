package za.ac.cput.services.contact;

import za.ac.cput.entity.Contact;
import za.ac.cput.services.IService;

import java.util.Set;

public interface IContactService extends IService<Contact,String> {
    public Set<Contact> getAll();

}

package za.ac.cput.controller.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Contact;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.services.contact.ContactService;


import java.util.Set;

@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/create")
    public Contact create(@RequestBody Contact contact){
        Contact newContact = ContactFactory.createContact( contact.getCellNumber(), contact.getWorkphone(), contact.getEmail());
        return  contactService.create(newContact);
    }
    @GetMapping("/read/{id}")
    public Contact read(@PathVariable String id){
        return contactService.read(id);
    }



    @PostMapping("/update")
    public Contact  update( @RequestBody  Contact contact){
        return contactService.update(contact);
    }
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        contactService.delete(id);

    }

    @GetMapping("/getall")
    public Set<Contact> getAll(){
        return contactService.getAll();
    }
}

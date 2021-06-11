/* ContactFactory.java
   Factory for the ContactFactory
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Contact;
import za.ac.cput.Util.GenericHelper;

public class ContactFactory {
    public static Contact createContact(String id,String cellNumber, String workPhone, String email){
        String contactId = GenericHelper.generateId();
        Contact contact = new Contact.Builder()
                .setId(contactId)
                .setCellNumber(cellNumber)
                .setWorkPhone(workPhone)
                .setEmail(email)
                .build();
        return contact;
    }
}


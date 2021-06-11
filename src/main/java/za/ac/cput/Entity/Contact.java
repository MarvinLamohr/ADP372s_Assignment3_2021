/* Contact.java
   Entity for the Contact
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */
package za.ac.cput.Entity;

public class Contact {

    private String id,cellNumber,workPhone,email;

    private  Contact(Builder builder){
        this.id = builder.id;
        this.cellNumber = builder.cellNumber;
        this.workPhone = builder.workPhone;
        this.email = builder.email;

    }
    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", cellNumber='" + cellNumber + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", email='" + email + '\'' +
                '}';

    }
    public static class Builder{
        private String id, cellNumber,workPhone,email;

        public Builder setId(String Id) {
            this.id = id;
            return this;
        }
        public Builder setCellNumber(String cellNumber) {
            this.cellNumber = cellNumber;
            return this;
        }

        public Builder setWorkPhone(String workPhone) {
            this.workPhone = workPhone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Contact build(){

            return new Contact(this);

        }

        public Contact.Builder copy(Contact contact) {
            this.id = contact.id;
            this.cellNumber = contact.cellNumber;
            this.workPhone = contact.workPhone;
            this.email = contact.email;


            return this;
        }
    }
}



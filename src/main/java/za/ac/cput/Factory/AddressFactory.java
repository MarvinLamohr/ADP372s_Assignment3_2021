/* AddressFactory.java
    Author: Mawande Langa (219074054)
    Date: 11/06/2021

 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Address;

public class AddressFactory {

    public static Address createAddress(String streetAddress, String postalAddress){

        Address address = new Address.Builder()
                .setStreetAddress(streetAddress)
                .setPostalAddress(postalAddress)
                .build();
        return address;

    }
}
